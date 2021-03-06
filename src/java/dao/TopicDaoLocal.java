package dao;

import java.util.List;
import javax.ejb.Local;
import model.Topic;

@Local
public interface TopicDaoLocal {
    
    void addTopic(Topic topic);
    
    void deleteTopic(int topicId);
    
    Topic getTopic(int topicId);
    
    void editTopic(Topic topic);
    
    List<Topic> getAllTopics();
    
    List<Topic> getAllTopicsByCategory(int categoryId);
    
    List<Topic> getTopTopics();
    
    boolean topicExists(int topicId);
    
}