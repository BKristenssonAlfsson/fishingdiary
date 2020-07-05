package se.njord.fishingdiary.domain.fishspecies;

import se.njord.fishingdiary.exception.DuplicateException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface FishSpeciesService {

    List<FishSpecies> getAllSpecies();
    FishSpecies addSpecies(String fish) throws DuplicateException;
}
