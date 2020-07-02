package se.njord.fishingdiary.domain.fish;

import se.njord.fishingdiary.exception.MissingVariableException;
import se.njord.fishingdiary.util.JsonConverter;

import javax.json.JsonObject;
import javax.persistence.*;

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

    @Column(name = "name", unique = true)
    private String name;

    public Fish() { }

    public Fish(String name) {
        this.name = name;
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

    public Fish toEntity(String fishModel) throws MissingVariableException {
        Fish fish = new Fish();
        JsonObject jsonObject = jsonConverter.jsonObjectFromString(fishModel);
        try {
            fish.name = jsonObject.getString("name");
        } catch ( NullPointerException nullPointerException ) {
            throw new MissingVariableException("There was no fish added as there was no variable named name");
        }

        return fish;
    }
}
