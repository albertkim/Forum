package controller;

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
     * READ URL PARAMETERS
         *********************************************************************
     */
    String topicParameter = request.getParameter("topicId");
    if (topicParameter != null && !"".equals(topicParameter)) {
      // The displayed posts will be different
      int topicId = Integer.parseInt(topicParameter);
      request.setAttribute("allPosts", postDao.getAllPostsWithTopicId(topicId));
      request.setAttribute("allUsers", userDao.getAllUsers());
      request.setAttribute("allTopics", topicDao.getAllTopics());
      session.setAttribute("topicId", topicParameter);
    } else {
      // Refresh page with all results
      request.setAttribute("allPosts", postDao.getAllPosts());
      request.setAttribute("allUsers", userDao.getAllUsers());
      request.setAttribute("allTopics", topicDao.getAllTopics());
    }

    request.getRequestDispatcher("index.jsp").forward(request, response);

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
