package wheretolunch.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@NamedQueries({
        @NamedQuery(name = HistoryRecord.ALL_VOTES_SORTED, query = "SELECT hr FROM HistoryRecord hr WHERE hr.type='vote' ORDER BY hr.dateTime"),
        @NamedQuery(name = HistoryRecord.MENU_HISTORY_SORTED, query = "SELECT hr FROM HistoryRecord hr WHERE hr.type='menu' ORDER BY hr.dateTime")
})
@Entity
@Table(name = "historyrecords")
public class HistoryRecord extends BaseEntity {

    public static final String ALL_VOTES_SORTED = "HistoryRecord.getUserVotesHistory";
    public static final String MENU_HISTORY_SORTED = "HistoryRecord.getRestaurantMenuHistory";


    @Column(name = "datetime")
    @NotBlank
    private LocalDateTime dateTime;

    @Column(name = "record")
    @NotBlank
    private String record;

    @Column(name = "type")
    @NotBlank
    private String type;

    public HistoryRecord() {
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
