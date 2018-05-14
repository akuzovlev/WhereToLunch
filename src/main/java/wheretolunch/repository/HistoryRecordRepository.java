package wheretolunch.repository;

import wheretolunch.model.HistoryRecord;

import java.util.List;

public interface HistoryRecordRepository {

    HistoryRecord save(HistoryRecord restaurant);

    List<HistoryRecord> getUserVotesHistory();

    List<HistoryRecord> getRestaurantsHistory();
}
