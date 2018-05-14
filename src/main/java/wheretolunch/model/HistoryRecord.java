package wheretolunch.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@NamedQueries({
        @NamedQuery(name = HistoryRecord.ALL_VOTES_SORTED, query = "SELECT hr FROM HistoryRecord hr WHERE hr.type='user' ORDER BY hr.dateTime"),
        @NamedQuery(name = HistoryRecord.MENU_HISTORY_SORTED, query = "SELECT hr FROM HistoryRecord hr WHERE hr.type='restaurant' ORDER BY hr.dateTime")
})
@Entity
@Table(name = "historyrecords")
public class HistoryRecord extends BaseEntity {

    public static final String ALL_VOTES_SORTED = "HistoryRecord.getUserVotesHistory";
    public static final String MENU_HISTORY_SORTED = "HistoryRecord.getRestaurantsMenuHistory";


    @Column(name = "datetime")
    @NotNull
    private LocalDateTime dateTime;

    @Column(name = "record")
    @NotBlank
    private String record;

    @Column(name = "type")
    @NotBlank
    private String type;

    public HistoryRecord() {
    }

    public HistoryRecord(@NotBlank LocalDateTime dateTime, @NotBlank String record, @NotBlank String type) {
        this.dateTime = dateTime;
        this.record = record;
        this.type = type;
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
