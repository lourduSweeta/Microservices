package microservices.book.multiplication.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Represents a Multiplication(a * b)
 */
@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public final class Multiplication {

    // Both factors
    private final int factorA;
    private final int factorB;

    //Empty constructor for JSON (de)serialization
    Multiplication()
    {
        this(0,0);
    }
}
