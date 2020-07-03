package se.njord.fishingdiary.domain.diary;

import se.njord.fishingdiary.util.JsonConverter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.List;

@Stateless
public class DiaryDataAccess implements DiaryService{

    private JsonConverter jsonConverter = new JsonConverter();

    @Inject
    private DiaryAccess diaryAccess;

    private Diary diary = new Diary();
    private DiaryModel diaryModel = new DiaryModel();

    @Override
    public DiaryModel createDiary(String username) {
        Diary response = diary.createDiary();
        JsonObject jsonObject = jsonConverter.jsonObjectFromString(username);

        diary = diaryAccess.addDiary(response, jsonObject.getString("username"));

        return diaryModel.toModel(diary);
    }

    @Override
    public List<DiaryModel> getAllDiaries() {
        List<Diary> diaries = diaryAccess.getAllDiaries();

        return diaryModel.toModelList(diaries);
    }

    @Override
    public DiaryModel getOneDiary(String username) {
        Diary diary = diaryAccess.getOneDiary(username);

        return diaryModel.toModel(diary);
    }
}
