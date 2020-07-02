package se.njord.fishingdiary.domain.fish;

import se.njord.fishingdiary.exception.DuplicateException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface FishAccess {
    List<Fish> getFishes();
    Fish addFish(Fish fish) throws DuplicateException;
}
