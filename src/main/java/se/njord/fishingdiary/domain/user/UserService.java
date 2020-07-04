package se.njord.fishingdiary.domain.user;

import se.njord.fishingdiary.exception.DuplicateException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserService {

    UserModel addUser(String userModel) throws DuplicateException;
    List<UserModel> getAllUsers();
}
