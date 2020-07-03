package se.njord.fishingdiary.domain.user;

import se.njord.fishingdiary.exception.DuplicateException;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

@Default
@Stateless
public class UserRepository implements UserAccess {

    @PersistenceContext(unitName = "fishdiary")
    private EntityManager entityManager;

    @Override
    public User addUser(User newUser) throws DuplicateException {
        try {
            entityManager.persist(newUser);
            return newUser;
        } catch (PersistenceException persistenceException) {
            throw new DuplicateException("User with name " + newUser.getUsername() + " do already exist");
        }
    }
}
