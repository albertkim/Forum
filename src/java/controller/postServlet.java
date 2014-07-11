package controller;

import dao.PostDaoLocal;
import dao.ProfileDaoLocal;
import dao.TopicDaoLocal;
import java.io.IOException;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Post;
import model.Profile;
import model.Topic;

@WebServlet(name = "postServlet", urlPatterns = {"/postServlet"})
public class postServlet extends HttpServlet {

  @EJB
  private ProfileDaoLocal userDao;
  @EJB
  private TopicDaoLocal topicDao;
    // @EJB
  // private CategoryDaoLocal categoryDao;
  @EJB
  private PostDaoLocal postDao;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession session = request.getSession(true);
    String action = request.getParameter("action");
    request.setAttribute("message", "No messages");

    /**
     * *********************************************************************
     * FORM INPUT
         *********************************************************************
     */
    if (action != null && !"".equals(action)) {

      if ("addPost".equalsIgnoreCase(action)) {
        String userIdString = request.getParameter("USERID");
        int userId = Integer.parseInt(userIdString);
        String parentIdString = request.getParameter("POSTID");
        String content = request.getParameter("CONTENT");
        int parentId = Integer.parseInt(parentIdString);
        String topicIdString = session.getAttribute("topicId").toString();
        int topicId = Integer.parseInt(topicIdString);
        Post post = new Post(userId, content, parentId, topicId);
        postDao.addPost(post);
        request.setAttribute("post", post);
      }
      
      else if ("addTopic".equalsIgnoreCase(action)) {
        String userIdString = request.getParameter("USERID");
        int userId = Integer.parseInt(userIdString);
        String categoryIdString = request.getParameter("CATEGORYID");
        String content = request.getParameter("CONTENT");
        int categoryId = Integer.parseInt(categoryIdString);
        Topic newTopic = new Topic(userId, categoryId, content);
        topicDao.addTopic(newTopic);
        request.setAttribute("topic", newTopic);
      }
      
      else if ("addUser".equalsIgnoreCase(action)) {
        String username = request.getParameter("USERNAME");
        String password = request.getParameter("PASSWORD");
        Profile user = new Profile(username, password);
        if (userDao.userExists(username)) {
          request.setAttribute("message", "Username already exists");
        } else {
          userDao.addUser(user);
        }
        request.setAttribute("user", user);
      }
      
      String topicIdString = session.getAttribute("topicId").toString();
      response.sendRedirect("mainServlet?topicId=" + topicIdString);
      
    } else {
      // Not sure how this would be reached. Just redirect to main page
      request.getRequestDispatcher("index.jsp").forward(request, response);
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
