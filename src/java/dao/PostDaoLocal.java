package dao;

import java.util.List;
import javax.ejb.Local;
import model.Post;

@Local
public interface PostDaoLocal {
    
    void addPost(Post post);
    
    void deletePost(int postId);
    
    void editPost(Post post);
    
    Post getPost(int postId);
    
    List<Post> getAllPosts();
    
    List<Post> getAllPostsWithTopicId(int topicId);
    
    void upvotePost(int postId);
    
    void removeUpvotePost(int postId);
    
    void downvotePost(int postId);
    
    void removeDownvotePost(int postId);
    
}