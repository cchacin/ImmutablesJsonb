![Eclipse MicroProfile logo](images/microprofile-logo.png)
![Eclipse JakartaEE logo](images/jakartaee-logo.png)

# ImmutableJsonb

 **ImmutableJsonb** is zero dependencies utility library that generates `Jsonb` immutable classes using the [Immutables.org](http://immutables.github.io/) library. 

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
- Annotated the class with ``
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

## Dependencies

| Library              | Version | Scope    |
|:---------------------|:--------|:---------|
| Eclipse JakartaEE    | 8.0.0   | Provided |
| Immutables           | 2.8.0   | Provided |

[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com) [![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)

[![forthebadge](https://forthebadge.com/images/badges/approved-by-george-costanza.svg)](https://forthebadge.com) [![forthebadge](https://forthebadge.com/images/badges/contains-technical-debt.svg)](https://forthebadge.com)