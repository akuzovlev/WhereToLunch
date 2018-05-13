package wheretolunch.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wheretolunch.model.HistoryRecord;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class HistoryRecordRepositoryImpl implements HistoryRecordRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public HistoryRecord save(HistoryRecord historyRecord) {
            em.persist(historyRecord);
            return historyRecord;
    }

    @Override
    public List<HistoryRecord> getUserVotesHistory() {
        return em.createNamedQuery(HistoryRecord.ALL_VOTES_SORTED, HistoryRecord.class).getResultList();
    }

    @Override
    public List<HistoryRecord> getRestaurantMenuHistory() {
        return em.createNamedQuery(HistoryRecord.MENU_HISTORY_SORTED, HistoryRecord.class).getResultList();
    }
}
