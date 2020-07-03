package se.njord.fishingdiary.domain.user;

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
}
