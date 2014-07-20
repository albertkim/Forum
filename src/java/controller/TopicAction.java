package controller;

import com.google.gson.Gson;
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
import model.Topic;

@WebServlet(name = "topicAction", urlPatterns = {"/topicAction"})
// Used for ajax calls dealing with topic content
public class TopicAction extends HttpServlet {

  @EJB
  private TopicDaoLocal topicDao;

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    // Check that the current user is an admin before proceeding
    HttpSession session = request.getSession(true);
    
    if(session.getAttribute("isAdmin").equals("true")){
      String action = request.getParameter("action").toString();
      if("deleteTopic".equals(action)){
        String topicId = request.getParameter("topicId").toString();
        // TODO: Decide what to do with reply posts
        topicDao.deleteTopic(Integer.parseInt(topicId));
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
