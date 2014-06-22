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
import model.Post;
import model.Profile;

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
        
        /***********************************************************************
         * FORM INPUT
         **********************************************************************/
        
        if(action != null && !"".equals(action)){
            System.out.println("Form input");
            String userIdString = request.getParameter("USERID");
            int userId = 0;
            if(!"".equals(userIdString) && userIdString!= null){
                userId = Integer.parseInt(userIdString);
            }

            String content = request.getParameter("CONTENT");

            String parentIdString = request.getParameter("PARENT");
            int parentId = 0;

            String topicIdString = session.getAttribute("topicId").toString();
            int topicId = Integer.parseInt(topicIdString);
            if(!"".equals(topicIdString) && topicIdString!=null){
                topicId = Integer.parseInt(topicIdString);
            }

            String username = request.getParameter("USERNAME");
            String password = request.getParameter("PASSWORD");
            String dateCreated = "2014-04-27";
            String lastLogin = "2014-04-28";

            Post post = new Post(userId, content, parentId, topicId);
            Profile user = new Profile(username, password, dateCreated, lastLogin);        

            if("addPost".equalsIgnoreCase(action)){
                postDao.addPost(post);
            }
            else if("addTopic".equalsIgnoreCase(action)){
                // Post newPost = new Post();
                // Topic newTopic = new Topic();
                topicDao.addTopic(null);
            }
            else if("addUser".equalsIgnoreCase(action)){
                if(userDao.userExists(username)){
                    request.setAttribute("message", "Username already exists");
                }
                else{
                    userDao.addUser(user);
                }
            }
            
            request.setAttribute("post", post);
            request.setAttribute("user", user);
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