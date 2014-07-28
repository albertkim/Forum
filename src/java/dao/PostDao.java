package dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Post;
import model.Profile;

@Stateless
public class PostDao implements PostDaoLocal {

  @PersistenceContext
  private EntityManager em;

  @Override
  public void addPost(Post post) {
    em.persist(post);
  }

  @Override
  public void deletePost(int postId) {
    // Deleting a post does not remove from database
    // Flags the post DELETED fields as true;
    Post post = getPost(postId);
    post.setDELETED(true);
    em.persist(post);
  }

  @Override
  public void editPost(Post post) {
    em.merge(post);
  }

  @Override
  // This method will also get back deleted posts, use wisely
  public Post getPost(int postId) {
    Post post = em.find(Post.class, postId);
    return setTransientFields(post);
  }

  @Override
  public List<Post> getAllPosts() {
    Query queryUser = em.createQuery("SELECT p FROM Post p WHERE p.DELETED = FALSE");
    List<Post> postList = queryUser.getResultList();
    List<Post> returnPostList = queryUser.getResultList();
    for(Post p: postList){
      returnPostList.add(setTransientFields(p));
    }
    return returnPostList;
  }

  @Override
  public List<Post> getAllPostsWithTopicId(int topicId) {
    Query queryUser = em.createQuery("SELECT p FROM Post p WHERE p.TOPICID = " + Integer.toString(topicId) + " AND p.DELETED = FALSE");
    List<Post> postList = queryUser.getResultList();
    List<Post> returnPostList = new ArrayList<>();
    for(Post p: postList){
      returnPostList.add(setTransientFields(p));
    }
    return returnPostList;
  }
  
  public Post setTransientFields(Post post){
    // Set username
    int userId = post.getUSERID();
    Query queryUser = em.createQuery("SELECT p FROM Profile p WHERE p.USERID = " + Integer.toString(userId));
    Profile user = (Profile) queryUser.getSingleResult();
    post.setUSERNAME(user.getUSERNAME());
    
    // Set parent post content
    int parentId = post.getPARENTID();
    if(parentId != 0){
      Post parentPost = getPost(parentId);
      post.setPARENTPOST(parentPost.getCONTENT());
      // Set parent username
      post.setPARENTUSERNAME(parentPost.getUSERNAME());
    }    
    
    // Set reply count
    int postId = post.getPOSTID();
    queryUser = em.createQuery("SELECT p FROM Post p WHERE p.PARENTID = " + Integer.toString(postId));
    List<Post> replies = queryUser.getResultList();
    post.setREPLIES(replies.size());
    
    return post;
  }

  @Override
  public void upvotePost(int postId) {
    // Checking to see if the user has already rated is done higher up in the servlet
    Post post = em.find(Post.class, postId);
    post.setUPVOTES(post.getUPVOTES() + 1);
    em.persist(post);
  }
  
  @Override
  public void removeUpvotePost(int postId){
    Post post = em.find(Post.class, postId);
    post.setUPVOTES(post.getUPVOTES() - 1);
    em.persist(post);
  }

  @Override
  public void downvotePost(int postId) {
    // Checking to see if the user has already rated is done higher up in the servlet
    Post post = em.find(Post.class, postId);
    post.setDOWNVOTES(post.getDOWNVOTES() + 1);
    em.merge(post);
  }
  
  @Override
  public void removeDownvotePost(int postId){
    Post post = em.find(Post.class, postId);
    post.setDOWNVOTES(post.getDOWNVOTES() - 1);
    em.merge(post);
  }

}