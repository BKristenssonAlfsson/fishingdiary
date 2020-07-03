package se.njord.fishingdiary.domain.diary;

import se.njord.fishingdiary.domain.fish.Fish;
import se.njord.fishingdiary.domain.user.User;

import java.util.ArrayList;
import java.util.List;

public class DiaryModel {

    private Long id;
    private List<Fish> catches = new ArrayList<>();
    private String username;

    public DiaryModel() {
    }

    public DiaryModel(List<Fish> catches, String username) {
        this.catches = catches;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Fish> getCatches() {
        return catches;
    }

    public void setCatches(List<Fish> catches) {
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
            diaryModels.add(diaryModel);
        });

        return diaryModels;
    }
}
