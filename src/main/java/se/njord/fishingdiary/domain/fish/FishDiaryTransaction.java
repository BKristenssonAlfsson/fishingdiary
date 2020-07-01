package se.njord.fishingdiary.domain.fish;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Default
@Stateless
public class FishDiaryTransaction implements FishDiaryAccess {

    @PersistenceContext(unitName = "fishdiary")
    private EntityManager entityManager;

    @Override
    public String getFishes() {
        return "fishes";
    }
}
