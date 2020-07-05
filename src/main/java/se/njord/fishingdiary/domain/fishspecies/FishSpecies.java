package se.njord.fishingdiary.domain.fishspecies;

import se.njord.fishingdiary.util.JsonConverter;

import javax.json.JsonObject;
import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "getAllFishSpecies" , query = "SELECT f FROM FishSpecies f")
})
public class FishSpecies {

    @Transient
    private JsonConverter jsonConverter = new JsonConverter();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    public FishSpecies() {}

    public FishSpecies(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FishSpecies toEntity(String fish) {
        FishSpecies fishSpecies = new FishSpecies();

        JsonObject jsonObject = jsonConverter.jsonObjectFromString(fish);

        fishSpecies.setName(jsonObject.getString("name"));

        return fishSpecies;
    }
}
