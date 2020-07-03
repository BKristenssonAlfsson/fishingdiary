package se.njord.fishingdiary.domain.diary;

import javax.ejb.Local;
import java.util.List;

@Local
public interface DiaryService {
    DiaryModel createDiary(String username);
    List<DiaryModel> getAllDiaries();
}
