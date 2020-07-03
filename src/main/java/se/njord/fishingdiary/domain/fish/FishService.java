package se.njord.fishingdiary.domain.fish;

import se.njord.fishingdiary.exception.DuplicateException;
import se.njord.fishingdiary.exception.MissingVariableException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface FishService {

    List<FishModel> getFishes();
    FishModel addFish(String fishModel) throws DuplicateException, MissingVariableException;
}
