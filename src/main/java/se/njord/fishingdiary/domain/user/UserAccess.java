package se.njord.fishingdiary.domain.user;

import se.njord.fishingdiary.exception.DuplicateException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserAccess {
    User addUser(User newUser) throws DuplicateException;

    List<User> getAllUsers();
}
