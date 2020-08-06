package microservices.book.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Identifies the attempt from a {@link User} to solve a
 * {@link Multiplication}.
 */

@Getter
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public final class MulltiplicationResultAttempt {
    private final User user;
    private final Multiplication multiplication;
    private final int resultAttempt;

    MulltiplicationResultAttempt()
    {
        user = null;
        multiplication = null;
        resultAttempt=-1;
    }
}
