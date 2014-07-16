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
  public void addAdmin(String username) {
    em.persist(new Admin(username));
  }

  @Override
  public void removeAdmin(Admin admin) {
    em.remove(admin);
  }

  @Override
  public boolean isAdmin(String username) {
    Query queryUser = em.createQuery("SELECT e FROM Admin e WHERE e.USERNAME = :username");
    queryUser.setParameter("username", username);
    return (queryUser.getResultList().size() >= 1);
  }

}