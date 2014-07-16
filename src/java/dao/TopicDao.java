package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Topic;

// Reference SQL call (when getting topic content via postId)
// "SELECT p.CONTENT FROM Post p WHERE p.POSTID = " + Integer.toString(postId)
@Stateless
public class TopicDao implements TopicDaoLocal {

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
  public Topic getTopic(int topicId) {
    Topic topic = em.find(Topic.class, topicId);
    return topic;
  }

  @Override
  public void editTopic(Topic topic) {
    em.merge(topic);
  }

  @Override
  public List<Topic> getAllTopics() {
    Query queryUser = em.createQuery("SELECT e FROM Topic e");
    List<Topic> topicList = queryUser.getResultList();
    return topicList;
  }

}