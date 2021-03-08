package se.lexicon.jpa_workshop.dao;

import org.springframework.stereotype.Repository;
import se.lexicon.jpa_workshop.entity.AppUser;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class AppUserDaoImpl implements AppUserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public AppUser create(AppUser appuser) {
         entityManager.persist(appuser);
         return appuser;
    }

    @Override
    public AppUser findById(int id) {
        return entityManager.find(AppUser.class, id);
    }

    @Override
    public List<AppUser> findAll() {
        Query query = entityManager.createQuery("select a from AppUser a");
        List<AppUser> result = query.getResultList();
        return result;
    }

    @Override
    public void remove(int id) {
        AppUser result = findById(id);
        if (result != null)
            entityManager.remove(result);

    }

    @Override
    @Transactional
    public AppUser merge(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Override
    public List<AppUser> saveAllAppUsers(List<AppUser> appUsers) {
        for (AppUser appUser: appUsers)
            create(appUser);
        return appUsers;
    }

    @Override
    public Optional<AppUser> findByEmail(String email) {
        Query query = entityManager.createQuery("select a from AppUser a where a.email = :ae");
        query.setParameter("ae", email);
        Optional<AppUser> result = query.getFirstResult();
        return result;
    }
}
