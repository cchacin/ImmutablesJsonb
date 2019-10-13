package immutables.jsonb;

import org.assertj.core.api.WithAssertions;
import org.immutables.value.Value;
import org.junit.jupiter.params.provider.Arguments;

import javax.json.JsonObject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

@Value.Immutable
public interface ArgumentCreator extends WithAssertions {

    Jsonb jsonb = JsonbBuilder.create();

    default String expectedJsonFilename() {
        return this.getObject().getClass().getSimpleName();
    }

    @Value.Parameter
    Object getObject();

    default JsonObject toJsonObject() {
        return jsonb.fromJson(jsonb.toJson(this.getObject()), JsonObject.class);
    }

    static Arguments of(final Object object) {
        return Arguments.of(ImmutableArgumentCreator.builder().object(object).build());
    }
}
