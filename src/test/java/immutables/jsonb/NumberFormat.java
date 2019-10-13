package immutables.jsonb;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbNumberFormat;

@ImmutableJsonb
public abstract class NumberFormat {

    @JsonbCreator
    public NumberFormat() {
    }

    @JsonbNumberFormat(value = "#0.000")
    public abstract Double getDouble();

    public static NumberFormat create() {
        return new NumberFormatInternalBuilder()
                .getDouble(10.01d)
                .build();
    }
}
