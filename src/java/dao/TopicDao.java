package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Topic;

// Reference SQL call (when getting topic content via postId)
// "SELECT p.CONTENT FROM Post p WHERE p.POSTID = " + Integer.toString(postId)
@Stateless
public class TopicDao implements TopicDaoLocal{

  @PersistenceContext
  private EntityManager em;

  @Override
  public void addTopic(Topic topic){
    em.persist(topic);
  }

  @Override
  public void deleteTopic(int topicId){
    em.remove(getTopic(topicId));
  }

  @Override
  public Topic getTopic(int topicId){
    Topic topic = em.find(Topic.class, topicId);
    return setTransientFields(topic);
  }

  @Override
  public void editTopic(Topic topic){
    em.merge(topic);
  }

  @Override
  public List<Topic> getAllTopics(){
    Query queryUser = em.createQuery("SELECT e FROM Topic e ORDER BY e.TOPICID");
    List<Topic> topicList = queryUser.getResultList();
    List<Topic> returnList = new ArrayList<>();
    for(Topic t: topicList){
      returnList.add(setTransientFields(t));
    }
    return returnList;
  }
  
  @Override
  public List<Topic> getAllTopicsByCategory(int  categoryId){
    Query queryUser = em.createQuery("SELECT e FROM Topic e WHERE e.CATEGORYID = :categoryId ORDER BY e.TOPICID");
    queryUser.setParameter("categoryId", categoryId);
    List<Topic> topicList = queryUser.getResultList();
    List<Topic> returnList = new ArrayList<>();
    for(Topic t: topicList){
      returnList.add(setTransientFields(t));
    }
    return returnList;
  }
  
  @Override
  public boolean topicExists(int topicId){
    Topic topic = em.find(Topic.class, topicId);
    return topic != null;
  }
  
  @Override
  public List<Topic> getTopTopics(){
    // TODO: Perform some sort of caching so that the whole database doesn't have to be scraped
    List<Topic> topicList = getAllTopics();
    Collections.sort(topicList, new Comparator<Topic>(){
      @Override
      public int compare(Topic x, Topic y) {
        return x.getREPLIES() - y.getREPLIES();
      }
    });
    Collections.reverse(topicList);
    return topicList;
  }
  
  public Topic setTransientFields(Topic topic){
    // Set replies
    Query queryUser = em.createQuery("SELECT p FROM Post p WHERE p.TOPICID = " + Integer.toString(topic.getTOPICID()) + " AND p.DELETED = false");
    int replies = queryUser.getResultList().size();
    topic.setREPLIES(replies);
    
    return topic;
  }

}