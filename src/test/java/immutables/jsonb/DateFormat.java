package immutables.jsonb;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@ImmutableJsonb
public abstract class DateFormat {

    @JsonbCreator
    public DateFormat() {
    }

    @JsonbDateFormat(value = "ss:hh:mm")
    public abstract LocalTime getLocalTime();

    @JsonbDateFormat(value = "dd-yyyy-MM")
    public abstract LocalDate getLocalDate();

    @JsonbDateFormat(value = "dd-yyyy-MM ss:hh:mm")
    public abstract LocalDateTime getLocalDateTime();

    static DateFormat create() {
        final LocalDate localDate = LocalDate.ofYearDay(2019, 63);
        final LocalTime localTime = LocalTime.of(6, 4);
        final LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        return new DateFormatInternalBuilder()
                .localTime(localTime)
                .localDate(localDate)
                .localDateTime(localDateTime)
                .build();
    }
}
