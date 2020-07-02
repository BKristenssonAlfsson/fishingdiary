package se.njord.fishingdiary.domain.fish;

import se.njord.fishingdiary.exception.DuplicateException;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import java.util.List;

@Default
@Stateless
public class FishTransaction implements FishAccess {

    @PersistenceContext(unitName = "fishdiary")
    private EntityManager entityManager;

    @Override
    public List<Fish> getFishes() {
        TypedQuery<Fish> query = entityManager.createNamedQuery("Fish.findAll", Fish.class);

        return query.getResultList();
    }

    @Override
    public Fish addFish(Fish fish) throws DuplicateException {
        try {
            entityManager.persist(fish);
            entityManager.flush();
            return fish;
        } catch (PersistenceException persistenceException) {
            throw new DuplicateException("Fish with name " + fish.getName() + " already exists.");
        }

    }
}
