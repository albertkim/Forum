package controller;

import dao.CategoryDaoLocal;
import dao.PostDaoLocal;
import dao.ProfileDaoLocal;
import dao.TopicDaoLocal;
import java.io.IOException;
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
  @EJB
  private CategoryDaoLocal categoryDao;
  @EJB
  private PostDaoLocal postDao;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    HttpSession session = request.getSession(true);
    String action = request.getParameter("action");
    session.setAttribute("message", "No messages");

    if (action != null && !"".equals(action)) {
      
      // addPost
      // Expected request parameters
      // USERID
      // POSTID
      // CONTENT

      if ("addPost".equalsIgnoreCase(action)) {
        String userIdString = request.getParameter("USERID");
        int userId = Integer.parseInt(userIdString);
        String parentIdString = request.getParameter("POSTID");
        
        // Get content string and parse to deal with new lines
        String content = request.getParameter("CONTENT").replaceAll("\\r|\\n", "<br>");
        System.out.println(content);
        
        if("".equals(content)){
          session.setAttribute("message", "Cannot make an empty post");
          String referer = request.getHeader("Referer");
          response.sendRedirect(referer);
          return;
        }
        
        int parentId = Integer.parseInt(parentIdString);
        String topicIdString = session.getAttribute("topicId").toString();
        int topicId = Integer.parseInt(topicIdString);
        Post post = new Post(userId, content, parentId, topicId);
        postDao.addPost(post);
        request.setAttribute("post", post);
      }
      
      // addTopic
      // Expected request parameters
      // USERID
      // currentCategory
      // CONTENT
      // TITLE
      
      else if ("addTopic".equalsIgnoreCase(action)) {
        // Add main topic entry
        String userIdString = request.getParameter("USERID");
        int userId = Integer.parseInt(userIdString);
        String categoryIdString = request.getParameter("currentCategory");
        System.out.println("categoryIdString: " + categoryIdString);
        String title = request.getParameter("TITLE");
        int categoryId = categoryDao.getCategoryId(categoryIdString);
        Topic newTopic = new Topic(userId, categoryId, title);
        topicDao.addTopic(newTopic);
        
        // Add first post entry, parent POSTID will be 0 by default
        int topicId = newTopic.getTOPICID();
        String content = request.getParameter("CONTENT");
        Post newPost = new Post(userId, content, 0, topicId);
        postDao.addPost(newPost);
        
      }
      
      // register
      // TODO: MAKE REGISTRATION PROCESS MORE SECURE!
      // Expected request parameters
      // USERNAME
      // PASSWORD
      
      else if ("register".equalsIgnoreCase(action)) {
        // TODO: Check username formatting
        String username = request.getParameter("USERNAME");
        String password = request.getParameter("PASSWORD");
        String confirmPassword = request.getParameter("CONFIRMPASSWORD");
        // Verify email formatting/uniqueness
        String email = request.getParameter("EMAIL");
        try{
          if (userDao.userExists(username)) {
            session.setAttribute("message", "Username already exists");
          } else if(!password.equals(confirmPassword)){
            session.setAttribute("message", "Passwords don't match");
          } else {
            Profile user = new Profile(username, password, email);
            userDao.addUser(user);
          }
        } catch(Exception e){
          System.out.println("Failed to create user " + username + " with password " + password);
          e.printStackTrace();
          session.setAttribute("message", "User could not be created");
        }
      }
      
      String referer = request.getHeader("Referer");
      response.sendRedirect(referer);
      
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
