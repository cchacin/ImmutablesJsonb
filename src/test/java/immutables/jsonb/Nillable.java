package immutables.jsonb;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbNillable;

@ImmutableJsonb
public abstract class Nillable {

    @JsonbCreator
    public Nillable() {
    }

    public abstract Internal getInternal();

    @JsonbNillable
    @ImmutableJsonb
    public abstract static class Internal {

        @JsonbCreator
        public Internal() {
        }

        public abstract String getField();
    }

    public static Nillable create() {
        return new NillableInternalBuilder()
                .internal(new InternalInternalBuilder().build())
                .build();
    }
}
