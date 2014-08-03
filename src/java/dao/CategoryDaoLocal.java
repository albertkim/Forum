package dao;

import java.util.List;
import javax.ejb.Local;
import model.Category;

@Local
public interface CategoryDaoLocal {

  void addCategory(Category category);

  void addCategory(String name);

  void deleteCategory(int id);

  Category getCategory(int id);

  Category getCategory(String name);

  int getCategoryId(String name);

  List<Category> getAllCategories();
  
  List<Category> getCustomCategories();

}
