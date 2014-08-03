package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Category;

@Stateless
public class CategoryDao implements CategoryDaoLocal {

  @PersistenceContext
  private EntityManager em;

  @Override
  public void addCategory(Category category) {
    em.persist(category);
  }

  @Override
  public void addCategory(String name) {
    em.persist(new Category(name));
  }

  @Override
  public void deleteCategory(int id) {
    em.remove(getCategory(id));
  }

  @Override
  public Category getCategory(int id) {
    return em.find(Category.class, id);
  }
  
  @Override
  public Category getCategory(String name) {
    Query queryUser = em.createQuery("SELECT e FROM Category e WHERE e.NAME = :name");
    queryUser.setParameter("name", name);
    return (Category) queryUser.getSingleResult();
  }

  @Override
  public int getCategoryId(String name) {
    return getCategory(name).getCATEGORYID();
  }

  @Override
  public List<Category> getAllCategories() {
    Query queryUser = em.createQuery("SELECT e FROM Category e");
    return queryUser.getResultList();
  }
  
  @Override
  public List<Category> getCustomCategories() {
    Query queryUser = em.createQuery("SELECT e FROM Category e WHERE e.CATEGORYID != 1 AND e.CATEGORYID != 2 AND e.CATEGORYID != 3 AND e.CATEGORYID != 4");
    return queryUser.getResultList();
  }

}