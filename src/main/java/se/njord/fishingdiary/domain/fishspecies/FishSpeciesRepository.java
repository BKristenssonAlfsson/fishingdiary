package se.njord.fishingdiary.domain.fishspecies;

import se.njord.fishingdiary.exception.DuplicateException;
import se.njord.fishingdiary.exception.MissingVariableException;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Default
public class FishSpeciesRepository implements FishSpeciesAccess {

    @PersistenceContext(unitName = "fishdiary")
    private EntityManager entityManager;

    public List<FishSpecies> getAllSpecies() {
        TypedQuery<FishSpecies> query = entityManager.createNamedQuery("getAllFishSpecies", FishSpecies.class);
        return query.getResultList();
    }

    public FishSpecies addSpecies(FishSpecies fish) throws DuplicateException {
        try {
            entityManager.persist(fish);
            return fish;
        } catch (PersistenceException persistenceException) {
            throw new DuplicateException(" You can't add a fish that already is inserted. Check the documentation");
        }
    }
}
