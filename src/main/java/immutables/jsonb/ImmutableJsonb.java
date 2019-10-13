package immutables.jsonb;

import org.immutables.value.Value.Style;

import javax.json.bind.annotation.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Style(
        defaultAsDefault = true,
        typeBuilder = "*InternalBuilder",
        implementationNestedInBuilder = true,
        validationMethod = Style.ValidationMethod.NONE,
        jacksonIntegration = false,
        of = "new",
        allParameters = true,
        passAnnotations = {
                JsonbAnnotation.class,
                JsonbCreator.class,
                JsonbDateFormat.class,
                JsonbNillable.class,
                JsonbNumberFormat.class,
                JsonbProperty.class,
                JsonbPropertyOrder.class,
                JsonbTransient.class,
                JsonbTypeAdapter.class,
                JsonbTypeSerializer.class,
                JsonbTypeDeserializer.class,
                JsonbVisibility.class
        },
        jdkOnly = true)
public @interface ImmutableJsonb {
}
