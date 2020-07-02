package se.njord.fishingdiary.domain.user;

import se.njord.fishingdiary.exception.DuplicateException;

import javax.ejb.Local;

@Local
public interface UserAccess {
    User addUser(User newUser) throws DuplicateException;
}
