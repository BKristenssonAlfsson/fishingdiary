package se.njord.fishingdiary.domain.fish;

import java.util.ArrayList;
import java.util.List;

public class FishModel {

    private Long id;
    private String name;
    private Double weight;
    private Double length;
    private Long diaryNumber;
    private String diaryOwner;

    public FishModel() {}

    public FishModel(String name, Double weight, Double length) {
        this.name = name;
        this.weight = weight;
        this.length = length;
    }

    public FishModel toFishModel(Fish fish) {
        FishModel fishModel = new FishModel(name, weight, length);

        fishModel.name = fish.getName();
        fishModel.length = fish.getLength();
        fishModel.weight = fish.getWeight();
        fish.getDiaries().forEach(diary -> {
            fishModel.diaryNumber = diary.getId();
            fishModel.diaryOwner = diary.getUser().getUsername();
        });

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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Long getDiaryNumber() {
        return diaryNumber;
    }

    public void setDiaryNumber(Long diaryNumber) {
        this.diaryNumber = diaryNumber;
    }

    public String getDiaryOwner() {
        return diaryOwner;
    }

    public void setDiaryOwner(String diaryOwner) {
        this.diaryOwner = diaryOwner;
    }

    public List<FishModel> toFishModelList(List<Fish> fishes) {
        List<FishModel> fishModelList = new ArrayList<>();

        fishes.forEach(fish -> {
            FishModel fishModel = new FishModel();
            fishModel.name = fish.getName();
            fishModel.length = fish.getLength();
            fishModel.weight = fish.getWeight();
            fish.getDiaries().forEach(diary -> {
                fishModel.setDiaryNumber(diary.getId());
                fishModel.setDiaryOwner(diary.getUser().getUsername());
            });

            fishModelList.add(fishModel);
        });

        return fishModelList;
    }
}
