package dao;

import java.util.List;
import model.Category;

public interface CategoryDaoLocal {
    
    void addCategory(Category category);
    
    void addCategory(String name);
    
    void deleteCategory(int id);
    
    Category getCategory(int id);
    
    Category getCategory(String name);
    
    int getCategoryId(String name);
    
    List<Category> getAllCategories();
    
}