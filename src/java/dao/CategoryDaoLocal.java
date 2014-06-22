package dao;

import java.util.List;
import model.Category;

public interface CategoryDaoLocal {
    
    void addCategory(Category category);
    
    void deleteCategory(int id);
    
    void editCategory(Category category);
    
    Category getCategory(int id);
    
    List<Category> getAllCategories();
    
}