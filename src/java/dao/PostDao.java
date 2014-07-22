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
    em.remove(getPost(postId));
  }

  @Override
  public void editPost(Post post) {
    em.merge(post);
  }

  @Override
  public Post getPost(int postId) {
    Post post = em.find(Post.class, postId);
    return setTransientFields(post);
  }

  @Override
  public List<Post> getAllPosts() {
    Query queryUser = em.createQuery("SELECT p FROM Post p");
    return queryUser.getResultList();
  }

  @Override
  public List<Post> getAllPostsWithTopicId(int topicId) {
    Query queryUser = em.createQuery("SELECT p FROM Post p WHERE p.TOPICID = " + Integer.toString(topicId));
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
    }
    
    // Set reply count
    int postId = post.getPOSTID();
    queryUser = em.createQuery("SELECT p FROM Post p WHERE p.PARENTID = " + Integer.toString(postId));
    List<Post> replies = queryUser.getResultList();
    post.setREPLIES(replies.size());
    
    return post;
  }

}