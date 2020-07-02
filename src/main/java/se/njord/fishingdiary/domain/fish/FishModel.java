package se.njord.fishingdiary.domain.fish;

public class FishModel {

    private Long id;
    private String name;

    public FishModel toFishModel(Fish fish) {
        FishModel fishModel = new FishModel();

        fishModel.name = fish.getName();

        return fishModel;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
