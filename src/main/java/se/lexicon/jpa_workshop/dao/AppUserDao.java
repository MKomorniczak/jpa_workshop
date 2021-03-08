package se.lexicon.jpa_workshop.dao;

import se.lexicon.jpa_workshop.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserDao {
    AppUser create(AppUser appuser);

    AppUser findById(int id);

    List<AppUser> findAll();

    void remove(int id);

    AppUser merge(AppUser appUser);

    List<AppUser> saveAllAppUsers(List<AppUser> appUsers);

    Optional<AppUser> findByEmail (String email);
}
