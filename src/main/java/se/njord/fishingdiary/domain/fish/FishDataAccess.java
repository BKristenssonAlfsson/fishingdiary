package se.njord.fishingdiary.domain.fish;

import se.njord.fishingdiary.exception.DuplicateException;
import se.njord.fishingdiary.exception.MissingVariableException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class FishDataAccess implements FishService {

    @Inject
    private FishAccess fishAccess;

    private Fish fish = new Fish();
    private FishModel fishModel = new FishModel();

    @Override
    public List<Fish> getFishes() {
        return fishAccess.getFishes();
    }

    @Override
    public FishModel addFish(String fishModel) throws DuplicateException, MissingVariableException {
        Fish fish = this.fish.toEntity(fishModel);
        fishAccess.addFish(fish);
        return this.fishModel.toFishModel(fish);
    }
}
