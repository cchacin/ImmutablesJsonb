![Eclipse MicroProfile logo](images/microprofile-logo.png)
![Eclipse JakartaEE logo](images/jakartaee-logo.png)

# ImmutableJsonb

 **ImmutableJsonb** is zero runtime dependencies utility library that generates `Jsonb` immutable classes using the [Immutables.org](http://immutables.github.io/) library. 

## Requirements

### Include the **Eclipse JakartaEE 8.0.0** (that includes `Jsonb`) dependency with provided scope (if not present):

```xml
<dependency>
    <groupId>jakarta.platform</groupId>
    <artifactId>jakarta.jakartaee-api</artifactId>
    <version>8.0.0</version>
    <scope>provided</scope>
</dependency>

``` 

### Include the `Immutables` dependency with provided scope:
```xml
<dependency>
    <groupId>org.immutables</groupId>
    <artifactId>value</artifactId>
    <version>2.8.0</version>
    <scope>provided</scope>
</dependency>
```

### Include the `ImmutablesJsonb` dependency with provided scope:
```xml
<dependency>
    <groupId>com.github.cchacin</groupId>
    <artifactId>immutables-jsonb</artifactId>
    <version>LATEST</version>
    <scope>provided</scope>
</dependency>
```

## How to use it

- Create an `abstract` class
- Annotated the class with `@ImmutableJsonb`
- Add a default constructor annotated with `@JsonbCreator`
- Add the abstract getters
- **That's it! Enjoy**

```java
@ImmutableJsonb
public abstract class MyPojo {

    @JsonbCreator
    public MyPojo() {
    }

    @JsonbProperty("anotherNameForField")
    public abstract Double getField();
    
    // rest of the getters omitted
}
```

## What do you get?

From the immutables library

> Java annotation processors to generate simple, safe and consistent value objects. Do not repeat yourself, try Immutables, the most comprehensive tool in this field!

#### Builder

```java
/**
 * Builds instances of type {@link MyPojoInternalBuilder.ImmutableMyPojo ImmutableMyPojo}.
 * Initialize attributes and then invoke the {@link #build()} method to create an
 * immutable instance.
 * <p><em>{@code MyPojoInternalBuilder} is not thread-safe and generally should not be stored in a field or collection,
 * but instead used immediately to create instances.</em>
 */
@Generated(from = "MyPojo", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.Generated("org.immutables.processor.ProxyProcessor")
public final class MyPojoInternalBuilder {
  private Double getDouble;
  /**
   * Creates a builder for {@link MyPojoInternalBuilder.ImmutableMyPojo ImmutableMyPojo} instances.
   * <pre>
   * new MyPojoInternalBuilder()
   *    .getDouble(Double | null) // nullable {@link MyPojo#getDouble() double}
   *    .build();
   * </pre>
   */
  public MyPojoInternalBuilder() {
  }
  /**
   * Fill a builder with attribute values from the provided {@code MyPojo} instance.
   * Regular attribute values will be replaced with those from the given instance.
   * Absent optional values will not replace present values.
   * @param instance The instance from which to copy values
   * @return {@code this} builder for use in a chained invocation
   */
  public final MyPojoInternalBuilder from(MyPojo instance) {
    Objects.requireNonNull(instance, "instance");
    Double getDoubleValue = instance.getDouble();
    if (getDoubleValue != null) {
      getDouble(getDoubleValue);
    }
    return this;
  }
  /**
   * Initializes the value for the {@link MyPojo#getDouble() double} attribute.
   * @param getDouble The value for getDouble (can be {@code null})
   * @return {@code this} builder for use in a chained invocation
   */
  public final MyPojoInternalBuilder getDouble(Double getDouble) {
    this.getDouble = getDouble;
    return this;
  }

  /**
   * Builds a new {@link MyPojoInternalBuilder.ImmutableMyPojo ImmutableMyPojo}.
   * @return An immutable instance of MyPojo
   * @throws java.lang.IllegalStateException if any required attributes are missing
   */
  public ImmutableMyPojo build() {
    return new MyPojoInternalBuilder.ImmutableMyPojo(getDouble);
  }
}
```

#### Generated Immutable implementation class nested in builder

```java
/**
 * Immutable implementation of {@link MyPojo}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code new MyPojoInternalBuilder()}.
 * Use the static factory method to create immutable instances:
 * {@code new MyPojoInternalBuilder.ImmutableMyPojo()}.
 */
@Generated(from = "MyPojo", generator = "Immutables")
public static final class ImmutableMyPojo extends MyPojo { 
    private final Double getDouble;

    /**
     * Construct a new immutable {@code MyPojo} instance.
     * @param getDouble The value for the {@code getDouble} attribute, can be {@code null}
     */
    @JsonbCreator
    public ImmutableMyPojo(@JsonbProperty("anotherNameForDouble") Double getDouble) {
      this.getDouble = getDouble;
    }

    /**
     * @return The value of the {@code getDouble} attribute
     */
    @JsonbProperty("anotherNameForDouble")
    @Override
    public Double getDouble() {
      return getDouble;
    }

    /**
     * Copy the current immutable object by setting a value for the {@link MyPojo#getDouble() double} attribute.
     * An equals check used to prevent copying of the same value by returning {@code this}.
     * @param value A new value for getDouble (can be {@code null})
     * @return A modified copy of the {@code this} object
     */
    public final MyPojoInternalBuilder.ImmutableMyPojo withDouble(Double value) {
      if (Objects.equals(this.getDouble, value)) return this;
      return new MyPojoInternalBuilder.ImmutableMyPojo(value);
    }

    /**
     * This instance is equal to all instances of {@code ImmutableMyPojo} that have equal attribute values.
     * @return {@code true} if {@code this} is equal to {@code another} instance
     */
    @Override
    public boolean equals(Object another) {
      if (this == another) return true;
      return another instanceof MyPojoInternalBuilder.ImmutableMyPojo
          && equalTo((MyPojoInternalBuilder.ImmutableMyPojo) another);
    }

    private boolean equalTo(MyPojoInternalBuilder.ImmutableMyPojo another) {
      return Objects.equals(getDouble, another.getDouble);
    }

    /**
     * Computes a hash code from attributes: {@code getDouble}.
     * @return hashCode value
     */
    @Override
    public int hashCode() {
      int h = 5381;
      h += (h << 5) + Objects.hashCode(getDouble);
      return h;
    }

    /**
     * Prints the immutable value {@code MyPojo} with attribute values.
     * @return A string representation of the value
     */
    @Override
    public String toString() {
      return "MyPojo{"
          + "double=" + getDouble
          + "}";
    }

    /**
     * Creates an immutable copy of a {@link MyPojo} value.
     * Uses accessors to get values to initialize the new immutable instance.
     * If an instance is already immutable, it is returned as is.
     * @param instance The instance to copy
     * @return A copied immutable MyPojo instance
     */
    public static MyPojoInternalBuilder.ImmutableMyPojo copyOf(MyPojo instance) {
      if (instance instanceof MyPojoInternalBuilder.ImmutableMyPojo) {
        return (MyPojoInternalBuilder.ImmutableMyPojo) instance;
      }
      return new MyPojoInternalBuilder()
          .from(instance)
          .build();
    }
}
```


## Dependencies

| Library              | Version | Scope    |
|:---------------------|:--------|:---------|
| Eclipse JakartaEE    | 8.0.0   | Provided |
| Immutables           | 2.8.0   | Provided |

[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com) [![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)

[![forthebadge](https://forthebadge.com/images/badges/approved-by-george-costanza.svg)](https://forthebadge.com) [![forthebadge](https://forthebadge.com/images/badges/contains-technical-debt.svg)](https://forthebadge.com)
