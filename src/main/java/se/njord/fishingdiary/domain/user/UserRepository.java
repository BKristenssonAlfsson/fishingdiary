package se.njord.fishingdiary.domain.user;

import se.njord.fishingdiary.exception.DuplicateException;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

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

    @Override
    public List<User> getAllUsers() {
        try {
            TypedQuery<User> query = entityManager.createNamedQuery("findAllUsers", User.class);

            return query.getResultList();
        } catch ( Exception e ) {
            throw new NullPointerException();
        }
    }
}
