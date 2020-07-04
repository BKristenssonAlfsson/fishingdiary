package se.njord.fishingdiary.domain.user;

import java.util.ArrayList;
import java.util.List;

public class UserModel {

    private String username;

    public UserModel() { }

    public UserModel(String username) {
        this.username = username;
    }

    public UserModel toModel(User user) {
        UserModel userModel = new UserModel();
        userModel.username = user.getUsername();

        return userModel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<UserModel> toModelList(List<User> users) {
        List<UserModel> userModels = new ArrayList<>();

        users.forEach(user -> {
            UserModel userModel = new UserModel();
            userModel.username = user.getUsername();
            userModels.add(userModel);
        });

        return userModels;
    }
}
