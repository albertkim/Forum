package controller;

import com.google.gson.Gson;
import dao.PostDaoLocal;
import dao.RatingAssocDaoLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.RatingAssoc;

@WebServlet(name = "ratingAction", urlPatterns = {"/ratingAction"})
public class RatingAction extends HttpServlet{
  
  @EJB
  private PostDaoLocal postDao;
  @EJB
  private RatingAssocDaoLocal ratingAssocDao;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    // Check that the current user is an admin before proceeding
    HttpSession session = request.getSession(true);
    
    if(session.getAttribute("currentUser") == null){
      session.setAttribute("message", "You must be logged in to rate posts");
      return;
    }
    
    System.out.println("RatingAction request=" + request);
    String action;
    int userId;
    int postId;
    
    try{
      action = request.getParameter("action");
      userId = Integer.parseInt(request.getParameter("userId"));
      postId = Integer.parseInt(request.getParameter("postId"));
    } catch(Exception e){
      e.printStackTrace();
      System.out.println("Invalid parameters set");
      return;
    }
    
    if("upvote".equals(action)){
      RatingAssoc ratingAssoc = ratingAssocDao.getRatingAssocByUserIdAndPostId(userId, postId);
      if(ratingAssoc != null){
        if(ratingAssoc.isUPVOTE()){
          // do nothing, already upvoted
        } else{
          // previously downvoted
          ratingAssoc.setUPVOTE(true);
          ratingAssocDao.edit(ratingAssoc);
          postDao.removeDownvotePost(postId);
          postDao.upvotePost(postId);
        }
      } else{
        // rating association does not already exist
        ratingAssocDao.addAssoc(userId, postId, true);
        postDao.upvotePost(postId);
      }
    }
    else if("downvote".equals(action)){
      RatingAssoc ratingAssoc = ratingAssocDao.getRatingAssocByUserIdAndPostId(userId, postId);
      if(ratingAssoc != null){
        if(ratingAssoc.isUPVOTE()){
          // previously upvoted
          ratingAssoc.setUPVOTE(false);
          ratingAssocDao.edit(ratingAssoc);
          postDao.removeUpvotePost(postId);
          postDao.downvotePost(postId);
        } else{
          // do nothing, already downvoted
        }
      } else{
        // rating association does not already exist
        ratingAssocDao.addAssoc(userId, postId, false);
        postDao.downvotePost(postId);
      }
    }

    // Return post model in JSON format
    String updatedPost = new Gson().toJson(postDao.getPost(postId));
    response.getWriter().write(updatedPost);
    
  }
  
}