package immutables.jsonb;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.json.Json;
import javax.json.JsonPatch;
import javax.json.JsonReader;
import java.util.stream.Stream;

class JsonbTest implements WithAssertions {

    static Stream<Arguments> data() {
        return Stream.of(
                ArgumentCreator.of(DateFormat.create()),
                ArgumentCreator.of(Nillable.create()),
                ArgumentCreator.of(NumberFormat.create()),
                ArgumentCreator.of(PropertyName.create()),
                ArgumentCreator.of(Transient.create())
        );
    }

    @ParameterizedTest(name = "Generated {0}")
    @MethodSource("data")
    void test(final ArgumentCreator argumentCreator) throws Exception {
        try (final JsonReader reader
                     = Json.createReader(this.getClass().getResourceAsStream("/" + argumentCreator.expectedJsonFilename() + ".json"))) {
            final JsonPatch diff = Json.createDiff(reader.readObject(), argumentCreator.toJsonObject());
            this.assertThat(diff.toJsonArray()).isEmpty();
            this.assertThat(diff.toString()).isEqualTo("[]");
        }
    }
}
