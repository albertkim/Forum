package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Category;

public class CategoryDao implements CategoryDaoLocal{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addCategory(Category category) {
        em.persist(category);
    }

    @Override
    public void deleteCategory(int id) {
        em.remove(getCategory(id));
    }

    @Override
    public void editCategory(Category category) {
        em.merge(category);
    }

    @Override
    public Category getCategory(int id) {
        return em.find(Category.class, id);
    }

    @Override
    public List<Category> getAllCategories() {
        Query queryUser = em.createQuery("SELECT e FROM Category e");
        return queryUser.getResultList();
    }
    
}
