package immutables.jsonb;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

@ImmutableJsonb
public abstract class PropertyName {

    @JsonbCreator
    public PropertyName() {
    }

    @JsonbProperty("anotherNameForDouble")
    public abstract Double getDouble();

    public static PropertyName create() {
        return new PropertyNameInternalBuilder()
                .getDouble(10.01d)
                .build();
    }
}
