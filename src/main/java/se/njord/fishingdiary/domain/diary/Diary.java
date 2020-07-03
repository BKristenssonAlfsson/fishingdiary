package se.njord.fishingdiary.domain.diary;

import se.njord.fishingdiary.domain.fish.Fish;
import se.njord.fishingdiary.domain.user.User;
import se.njord.fishingdiary.util.JsonConverter;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "getAllDiaries", query = "SELECT d FROM Diary d")
})
public class Diary {

    @Transient
    private JsonConverter jsonConverter = new JsonConverter();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "diary")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "diary_fishes",
            joinColumns = @JoinColumn(name = "diary_id"),
            inverseJoinColumns = @JoinColumn(name = "fish_id")
    )
    private List<Fish> catches;

    public Diary() {}

    public Diary(User user, List<Fish> catches) {
        this.user = user;
        this.catches = catches;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Fish> getCatches() {
        return catches;
    }

    public void setCatches(List<Fish> catches) {
        this.catches = catches;
    }



    public Diary createDiary() {
        return new Diary();
    }
}
