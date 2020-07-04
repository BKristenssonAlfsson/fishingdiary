package se.njord.fishingdiary.domain.user;

import se.njord.fishingdiary.exception.DuplicateException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class UserDataAccess implements UserService {

    private User user = new User();
    private UserModel userModel = new UserModel();

    @Inject
    UserAccess userAccess;

    @Override
    public UserModel addUser(String userModel) throws DuplicateException {
        User newUser = userAccess.addUser(user.toEntity(userModel));

        return this.userModel.toModel(newUser);
    }

    @Override
    public List<UserModel> getAllUsers() {
        List<User> users =  userAccess.getAllUsers();

        List<UserModel> userModels = this.userModel.toModelList(users);

        return userModels;
    }
}
