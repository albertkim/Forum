package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Admin;

@Stateless
public class AdminDao implements AdminDaoLocal {

  @PersistenceContext
  private EntityManager em;

  @Override
  public void addAdmin(int userId) {
    em.persist(new Admin(userId));
  }

  @Override
  public void removeAdmin(Admin admin) {
    em.remove(admin);
  }

  @Override
  public boolean isAdmin(int userId) {
    Query queryUser = em.createQuery("SELECT e FROM Admin e WHERE e.USERID = :userId");
    queryUser.setParameter("userId", userId);
    return (queryUser.getResultList().size() >= 1);
  }

}