package dao;

import javax.ejb.Local;
import model.Admin;

@Local
public interface AdminDaoLocal {

  void addAdmin(String username);
  
  void removeAdmin(Admin admin);
  
  boolean isAdmin(String username);
  
}