package dao;

import java.util.List;
import javax.ejb.Local;
import model.Profile;

@Local
public interface ProfileDaoLocal {
    
    void addUser(Profile user);
    
    void deleteUser(int userId);
    
    void editUser(Profile user);
    
    Profile getUser(int userId);
    
    List<Profile> getAllUsers();
    
    boolean userExists(String username);
    
    boolean verifyUser(String username, String password);
    
}
