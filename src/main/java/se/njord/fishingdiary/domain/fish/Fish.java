package se.njord.fishingdiary.domain.fish;

import se.njord.fishingdiary.domain.diary.Diary;
import se.njord.fishingdiary.exception.MissingVariableException;
import se.njord.fishingdiary.util.JsonConverter;

import javax.json.JsonObject;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fish")
@NamedQueries({
        @NamedQuery(name="Fish.findAll", query="SELECT f FROM Fish f")
})
public class Fish {

    @Transient
    private JsonConverter jsonConverter = new JsonConverter();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column
    private Double length;

    @Column
    private Double weight;

    @ManyToMany(mappedBy = "catches",
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    private Set<Diary> diaries = new HashSet<>();

    public Fish() { }

    public Fish(String name, Double length, Double weight) {
        this.name = name;
        this.length = length;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Set<Diary> getDiaries() {
        return diaries;
    }

    public void setDiaries(Set<Diary> diaries) {
        this.diaries = diaries;
    }

    public Fish toEntity(JsonObject fishModel) throws MissingVariableException {
        Fish fish = new Fish();
        try {
            fish.setName(fishModel.getString("name"));
            fish.setLength(fishModel.getJsonNumber("length").doubleValue());
            fish.setWeight(fishModel.getJsonNumber("weight").doubleValue());
        } catch ( NullPointerException nullPointerException ) {
            throw new MissingVariableException("One or several variables where missing");
        }

        return fish;
    }

    public void addDiary(Diary diary) {
        System.out.println();
        this.diaries.add(diary);
        diary.getCatches().add(this);
    }

    public void removeFish(Diary diary) {
        this.diaries.remove(diary);
        diary.getCatches().remove(this);
    }
}
