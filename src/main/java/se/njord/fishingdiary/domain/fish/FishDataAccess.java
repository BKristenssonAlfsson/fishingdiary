package se.njord.fishingdiary.domain.fish;

import mjson.Json;
import se.njord.fishingdiary.domain.diary.Diary;
import se.njord.fishingdiary.domain.diary.DiaryAccess;
import se.njord.fishingdiary.exception.DuplicateException;
import se.njord.fishingdiary.exception.MissingVariableException;
import se.njord.fishingdiary.util.JsonConverter;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.JsonObject;
import java.util.List;

@Stateless
public class FishDataAccess implements FishService {

    private JsonConverter jsonConverter = new JsonConverter();

    @Inject
    private FishAccess fishAccess;

    @Inject
    private DiaryAccess diaryAccess;

    private Fish fish = new Fish();
    private FishModel fishModel = new FishModel();

    @Override
    public List<FishModel> getFishes() {
        List<Fish> fishes = fishAccess.getFishes();

        return fishModel.toFishModelList(fishes);
    }

    @Override
    public FishModel addFish(String fishModel) throws DuplicateException, MissingVariableException {
        JsonObject jsonObject = jsonConverter.jsonObjectFromString(fishModel);

        Fish fish = this.fish.toEntity(jsonObject);
        fishAccess.addFish(fish);
        Diary diary = diaryAccess.getOneDiary(jsonObject.getString("username"));

        diary.addFish(fish);

        return this.fishModel.toFishModel(fish);
    }
}
