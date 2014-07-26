package dao;

import javax.ejb.Local;
import model.RatingAssoc;

@Local
public interface RatingAssocDaoLocal {

  void addAssoc(int userId, int postId, boolean upvote);
  
  boolean alreadyRated(int userId, int postId);
  
  RatingAssoc getRatingAssocByUserIdAndPostId(int userId, int postId);
  
  void edit(RatingAssoc ratingAssoc);
  
}