package microservices.book.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Stores information to identify the user.
 */
@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public final class User {
    private final String alias;

    //Empty contructor for JSON(de)serialization
    protected User()
    {
        alias=null;
    }
}
