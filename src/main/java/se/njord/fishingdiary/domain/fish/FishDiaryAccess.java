package se.njord.fishingdiary.domain.fish;

import javax.ejb.Local;

@Local
public interface FishDiaryAccess {
    String getFishes();
}
