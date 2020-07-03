package se.njord.fishingdiary.domain.diary;

import se.njord.fishingdiary.domain.fish.FishModel;
import java.util.ArrayList;
import java.util.List;

public class DiaryModel {

    private Long id;
    private FishModel catches;
    private String username;

    public DiaryModel() {
    }

    public DiaryModel(FishModel catches, String username) {
        this.catches = catches;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FishModel getCatches() {
        return catches;
    }

    public void setCatches(FishModel catches) {
        this.catches = catches;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public DiaryModel toModel(Diary diary) {
        DiaryModel diaryModel = new DiaryModel();
        diaryModel.setUser(diary.getUser().getUsername());
        diary.getCatches().forEach(fish -> {
            FishModel fishModel = new FishModel();
            fishModel.setName(fish.getName());
            fishModel.setWeight(fish.getWeight());
            fishModel.setLength(fish.getLength());
            diaryModel.setCatches(fishModel);
        });
        return diaryModel;
    }

    public List<DiaryModel> toModelList(List<Diary> diaries) {
        List<DiaryModel> diaryModels = new ArrayList<>();

        diaries.forEach(diary -> {
            DiaryModel diaryModel = new DiaryModel();
            diaryModel.setId(diary.getId());
            try {
                diaryModel.setUser(diary.getUser().getUsername());
            } catch (NullPointerException npe ) {
                diaryModel.setUser("No user found");
            }

            diary.getCatches().forEach(fish -> {
                FishModel fishModel = new FishModel();
                fishModel.setName(fish.getName());
                fishModel.setWeight(fish.getWeight());
                fishModel.setLength(fish.getLength());
                diaryModel.setCatches(fishModel);
            });

            diaryModels.add(diaryModel);
        });

        return diaryModels;
    }
}
