package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Post;

@Stateless
public class PostDao implements PostDaoLocal{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addPost(Post post){
        em.persist(post);
    }

    @Override
    public void deletePost(int postId) {
        em.remove(postId);
    }

    @Override
    public void editPost(Post post) {
        em.merge(post);
    }

    @Override
    public Post getPost(int postId) {
        return em.find(Post.class, postId);
    }
    
    @Override
    public List<Post> getAllPosts() {
        return em.createNamedQuery("Post.getAll").getResultList();
    }
    
    @Override
    public List<Post> getAllPostsWithTopicId(int topicId){
        Query queryUser = em.createQuery("SELECT p FROM Post p WHERE p.TOPICID = " + Integer.toString(topicId));
        return queryUser.getResultList();
    }
    
}