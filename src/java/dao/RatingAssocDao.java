package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.RatingAssoc;

@Stateless
public class RatingAssocDao implements RatingAssocDaoLocal {

  @PersistenceContext
  private EntityManager em;

  @Override
  public void addAssoc(int userId, int postId, boolean upvote) {
    RatingAssoc ratingAssoc = new RatingAssoc(userId, postId, upvote);
    em.persist(ratingAssoc);
  }

  @Override
  public boolean alreadyRated(int userId, int postId) {
    Query queryUser = em.createQuery("SELECT r FROM RatingAssoc r WHERE r.USERID = :userId AND r.POSTID = :postId");
    queryUser.setParameter("userId", userId);
    queryUser.setParameter("postId", postId);
    return queryUser.getSingleResult() != null;
  }
  
  @Override
  public RatingAssoc getRatingAssocByUserIdAndPostId(int userId, int postId) {
    Query queryUser = em.createQuery("SELECT r FROM RatingAssoc r WHERE r.USERID = :userId AND r.POSTID = :postId");
    queryUser.setParameter("userId", userId);
    queryUser.setParameter("postId", postId);
    RatingAssoc result;
    try{
      result = (RatingAssoc) queryUser.getSingleResult();
    } catch(javax.persistence.NoResultException e){
      return null;
    }
    return result;
  }
  
  @Override
  public void edit(RatingAssoc ratingAssoc){
    em.merge(ratingAssoc);
  }

}