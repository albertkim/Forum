package controller;

import dao.AdminDaoLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "adminServlet", urlPatterns = {"/adminServlet"})
public class adminServlet extends HttpServlet{
  
  @EJB
  private AdminDaoLocal adminDao;
  
  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession(true);
    String action = request.getParameter("action");
    
    if(session.getAttribute("isAdmin").toString().equals("true")){
      // User is an admin, allow him/her to proceed
      System.out.println("Administrator verified");
      
      
      String referer = request.getHeader("Referer");
      response.sendRedirect(referer);
    }
    // If not admin, return to prev page with warning
    else{
      session.setAttribute("message", "Nice try, but you're not an admin");
      String referer = request.getHeader("Referer");
      response.sendRedirect(referer);
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
