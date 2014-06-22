package dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Topic;

@Stateless
public class TopicDao implements TopicDaoLocal{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addTopic(Topic topic) {
        em.persist(topic);
    }

    @Override
    public void deleteTopic(int topicId) {
        em.remove(getTopic(topicId));
    }
    
    @Override
    public Topic getTopic(int topicId){
        return em.find(Topic.class, topicId);
    }

    @Override
    public void editTopic(Topic topic) {
        em.merge(topic);
    }

    @Override
    public List<Topic> getAllTopics() {
        Query queryUser = em.createQuery("SELECT e FROM Topic e");
        return queryUser.getResultList();
    }
    
    @Override
    public String getTopicContent(int topicId){
        Topic topic = getTopic(topicId);
        System.out.println("Returned topic postId: " + topic.getPOSTID());
        int postId = topic.getPOSTID();
        Query queryUser = em.createQuery("SELECT p.CONTENT FROM Post p WHERE p.POSTID = " + Integer.toString(postId));
        return queryUser.getSingleResult().toString();
    }
    
    @Override
    public List<String> getAllTopicContent(){
        List<Topic> allTopics = getAllTopics();
        List<String> allTopicContent = new ArrayList<String>();
        for(Topic t: allTopics){
            allTopicContent.add(getTopicContent(t.getTOPICID()));
        }
        return allTopicContent;
    }
    
}
