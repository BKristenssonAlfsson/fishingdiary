package se.njord.fishingdiary.domain.user;

import se.njord.fishingdiary.util.JsonConverter;

import javax.json.JsonObject;
import javax.persistence.*;

@Entity
@Table(name = "person")
public class User {

    @Transient
    JsonConverter jsonConverter = new JsonConverter();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true)
    private String username;

    @Column
    private String password;

    public User() { }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public User toEntity(String userModel) {
        var user = new User();

        JsonObject jsonObject = jsonConverter.jsonObjectFromString(userModel);

        user.setUsername(jsonObject.getString("username"));
        user.setPassword(jsonObject.getString("password"));

        return user;
    }
}
