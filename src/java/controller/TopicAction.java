package controller;

import com.google.gson.Gson;
import dao.PostDaoLocal;
import dao.TopicDaoLocal;
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
import model.Topic;

@WebServlet(name = "topicAction", urlPatterns = {"/topicAction"})
// Used for ajax calls dealing with topic content
public class TopicAction extends HttpServlet {

  @EJB
  private TopicDaoLocal topicDao;
  @EJB
  private PostDaoLocal postDao;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // Check that the current user is an admin before proceeding
    HttpSession session = request.getSession(true);
    
    if(session.getAttribute("isAdmin").equals("true")){
      String action = request.getParameter("action").toString();
      if("deleteTopic".equals(action)){
        String topicIdString = request.getParameter("topicId").toString();
        int topicId = Integer.parseInt(topicIdString);
        topicDao.deleteTopic(topicId);
        
        // Delete all posts with topicId
        List<Post> posts = postDao.getAllPostsWithTopicId(topicId);
        for(Post p: posts){
          postDao.deletePost(p.getPOSTID());
        }
        
        // Get new list of posts
        String currentTopicId = request.getParameter("topicId").toString();
        List<Topic> allTopics = topicDao.getAllTopics();
        String allTopicsJson = new Gson().toJson(allTopics);
        response.getWriter().write(allTopicsJson);
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
