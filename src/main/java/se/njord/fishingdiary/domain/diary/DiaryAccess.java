package se.njord.fishingdiary.domain.diary;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DiaryAccess {

    Diary addDiary(Diary diary, String username);
    List<Diary> getAllDiaries();
}
