package dao;

import javax.ejb.Local;
import model.Admin;

@Local
public interface AdminDaoLocal {

  void addAdmin(int userId);
  
  void removeAdmin(Admin admin);
  
  boolean isAdmin(int userId);
  
}