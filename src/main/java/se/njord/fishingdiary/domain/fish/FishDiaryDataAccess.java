package se.njord.fishingdiary.domain.fish;

import javax.inject.Inject;

public class FishDiaryDataAccess implements FishService {

    @Inject
    private FishDiaryAccess fishDiaryAccess;


    @Override
    public String getFishes() {
        return fishDiaryAccess.getFishes();
    }
}
