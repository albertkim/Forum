package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Profile;

@Stateless
public class ProfileDao implements ProfileDaoLocal{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void addUser(Profile profile) {
        em.persist(profile);
    }

    @Override
    public void deleteUser(int profileId) {
        em.remove(getUser(profileId));
    }
    
    @Override
    public void editUser(Profile profile) {
        em.merge(profile);
    }

    @Override
    public Profile getUser(int profileId) {
        return em.find(Profile.class, profileId);
    }
    
    @Override
    public List<Profile> getAllUsers() {
        return em.createNamedQuery("Profile.getAll").getResultList();
    }
    
    @Override
    public boolean userExists(String username) {
        Query queryUser = em.createQuery("SELECT e FROM Profile e WHERE e.USERNAME = :username");
        queryUser.setParameter("username", username);
        return queryUser.getResultList().size() > 0;
    }
    
}
