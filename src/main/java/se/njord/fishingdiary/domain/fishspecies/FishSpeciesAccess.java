package se.njord.fishingdiary.domain.fishspecies;

import se.njord.fishingdiary.exception.DuplicateException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface FishSpeciesAccess {

    List<FishSpecies> getAllSpecies();
    FishSpecies addSpecies(FishSpecies fish) throws DuplicateException;
}
