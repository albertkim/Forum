package controller;

import dao.AdminDaoLocal;
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

@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

  @EJB
  private ProfileDaoLocal profileDao;
  @EJB
  private TopicDaoLocal topicDao;
  @EJB
  private AdminDaoLocal adminDao;
  @EJB
  private PostDaoLocal postDao;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    HttpSession session = request.getSession(true);
    String action = request.getParameter("action");

    if (action != null && !"".equals(action)) {

      if ("login".equalsIgnoreCase(action)) {
        String username = request.getParameter("USERNAME");
        String password = request.getParameter("PASSWORD");
        try {
          if(profileDao.userExists(username)){
            int userId = profileDao.getUser(username).getUSERID();
            if(profileDao.verifyUser(username, password)){
              System.out.println("User " + username + " has successfully logged in");
              session.setAttribute("message", "Logged in successfully");
              session.setAttribute("currentUser", profileDao.getUser(username));
              if(adminDao.isAdmin(userId)){
                session.setAttribute("isAdmin", "true");
              }
            }
            else{
              // Username/password combination incorrect
              System.out.println("Attempted username: " + username);
              System.out.println("Attempted password: " + password);
              session.setAttribute("message", "Username/password combination was incorrect");
            }
          } else{
            // User doesn't exist. Return with error message
            session.setAttribute("message", "User does not exist");
          }
        } catch (Exception e) {
          System.out.println("Couldn't hash password " + password);
          e.printStackTrace();
        }
      }
      if("logout".equalsIgnoreCase(action)){
        session.removeAttribute("currentUser");
        session.removeAttribute("isAdmin");
        session.setAttribute("message", "Logged out");
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