package controller;

import com.google.gson.Gson;
import dao.PostDaoLocal;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Post;

@WebServlet(name = "postAction", urlPatterns = {"/postAction"})
// Used for ajax calls dealing with post content
public class PostAction extends HttpServlet {

  @EJB
  private PostDaoLocal postDao;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // Check that the current user is an admin before proceeding
    HttpSession session = request.getSession(true);
    
    String action = request.getParameter("action").toString();
    
    // upvote
    // Expected request parameters
    // postId
    // userId
    if("upvote".equals(action)){
      
    }
    
    if(session.getAttribute("isAdmin").equals("true")){
      
      // deletePost
      // Expected request parameters
      // postId
      // topicId
      
      if("deletePost".equals(action)){
        String postId = request.getParameter("postId").toString();
        // TODO: Decide what to do with reply posts
        postDao.deletePost(Integer.parseInt(postId));
        // Get new list of posts
        String topicId = request.getParameter("topicId").toString();
        List<Post> allPosts = postDao.getAllPostsWithTopicId(Integer.parseInt(topicId));
        String allPostsJson = new Gson().toJson(allPosts);
        response.getWriter().write(allPostsJson);
      }
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

}
