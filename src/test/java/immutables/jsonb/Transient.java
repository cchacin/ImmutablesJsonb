package immutables.jsonb;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbTransient;

@ImmutableJsonb
public abstract class Transient {

    @JsonbCreator
    public Transient() {
    }

    public abstract String getNonTransientField();

    @JsonbTransient
    public abstract String getTransientField();

    public static Transient create() {
        return new TransientInternalBuilder()
                .transientField("transientField")
                .nonTransientField("nonTransientField")
                .build();
    }
}
