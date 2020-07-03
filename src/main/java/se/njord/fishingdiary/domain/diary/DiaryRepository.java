package se.njord.fishingdiary.domain.diary;

import se.njord.fishingdiary.domain.user.User;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.*;
import java.util.List;

@Default
@Stateless
public class DiaryRepository implements DiaryAccess {

    @PersistenceContext(unitName = "fishdiary")
    private EntityManager entityManager;

    @Override
    public Diary addDiary(Diary diary, String username) {
        User user = getUser(username);
        diary.setUser(user);
        user.setDiary(diary);
        try {
            entityManager.persist(diary);
            return diary;
        } catch ( PersistenceException persistenceException ) {
            throw persistenceException;
        }
    }

    @Override
    public List<Diary> getAllDiaries() {
        TypedQuery<Diary> query = entityManager.createNamedQuery("getAllDiaries", Diary.class);

        return query.getResultList();
    }

    private User getUser(String username) {
        Query query = entityManager.createNamedQuery("findUser", User.class).setParameter("username", username);
        return (User)query.getSingleResult();
    }
}
