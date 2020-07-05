package se.njord.fishingdiary.domain.fishspecies;

import se.njord.fishingdiary.exception.DuplicateException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class FishSpeciesDataAccess implements FishSpeciesService {

    private FishSpecies fishSpecies = new FishSpecies();

    @Inject
    private FishSpeciesAccess fishSpeciesAccess;

    public List<FishSpecies> getAllSpecies() {
        return fishSpeciesAccess.getAllSpecies();
    }

    public FishSpecies addSpecies(String fish) throws DuplicateException {
        FishSpecies species = this.fishSpecies.toEntity(fish);
        return fishSpeciesAccess.addSpecies(species);
    }
}
