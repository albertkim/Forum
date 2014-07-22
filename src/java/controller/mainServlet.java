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

@WebServlet(name = "mainServlet", urlPatterns = {"/mainServlet"})
public class mainServlet extends HttpServlet {

  @EJB
  private ProfileDaoLocal userDao;
  @EJB
  private TopicDaoLocal topicDao;
  @EJB
  private PostDaoLocal postDao;
  @EJB
  private CategoryDaoLocal categoryDao;
  
  /**
   * This servlet reads URL parameters and sends back relevant data
   * The first parameter to read is the Category
   * Once the category is verified, the topic parameter is read
   * Must consider null/non-existent parameters
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession session = request.getSession(true);
    
    // Get categories
    request.setAttribute("allCategories", categoryDao.getAllCategories());
    
    // Process category parameter
    String category = request.getParameter("category");
    if(category != null){
      int categoryId = categoryDao.getCategoryId(category);
      request.setAttribute("allTopics", topicDao.getAllTopicsByCategory(categoryId));
      
      // Then process topic parameter
      String topicIdString = request.getParameter("topicId");
      if (topicIdString != null) {
        int topicId = Integer.parseInt(topicIdString);
        // Return to home page if topic does not exist
        // TODO: Deal with returning to home page when the url is invalid
        if(!topicDao.topicExists(topicId)){
          response.sendRedirect("mainServlet");
          return;
        }
        request.setAttribute("allPosts", postDao.getAllPostsWithTopicId(topicId));
        session.setAttribute("topicId", topicIdString);
      }
    } else {
      session.setAttribute("message", "No messages");
    }

    request.getRequestDispatcher("index.jsp").forward(request, response);
    session.setAttribute("message", "No messages");

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
