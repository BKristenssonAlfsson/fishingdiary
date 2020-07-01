package se.njord.fishingdiary.domain.fish;

import javax.ejb.Local;

@Local
public interface FishDiaryService {

    String getFishes();
}
