package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.MulltiplicationResultAttempt;
import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import  static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

public class MultiplicationServiceImplTest {

    private MultiplicationServiceImpl multiplicationServiceImpl;
    @Mock
    RandomGeneratorService randomGeneratorService;

    @Before
    public void setUp() {
        //with this call to initMocks we tell mockito to process the annotations
        MockitoAnnotations.initMocks(this);
        multiplicationServiceImpl = new MultiplicationServiceImpl(randomGeneratorService);
    }

    @Test
    public void createRandomMultiplicationTest(){
        //given (our mocked RandomGenerateService will return first 50 then 30 )
        given(randomGeneratorService.generateRandomFactor()).willReturn(50,30);

        //when
        Multiplication multiplication = multiplicationServiceImpl.createRandomMultiplication();

        //then
        assertThat(multiplication.getFactorA()).isEqualTo(50);
        assertThat(multiplication.getFactorB()).isEqualTo(30);
        //assertThat(multiplication.getResult()).isEqualTo(1500);

    }

    @Test
    public void checkCorrectAttemptTest(){
        //given
        Multiplication multiplication =new Multiplication(30,60);
        User user = new User("Joshua");
        MulltiplicationResultAttempt attempt= new MulltiplicationResultAttempt(
                user,multiplication,1800
        );

        //when
        boolean resultAttempt = multiplicationServiceImpl.checkAttempt(attempt);

        //then
        assertThat(resultAttempt).isTrue();
    }

    @Test
    public void  checkWrongAttemptTest(){
        //given
        Multiplication multiplication = new Multiplication(20,30);
        User user = new User("Joshua");
        MulltiplicationResultAttempt attempt = new MulltiplicationResultAttempt(
                user,multiplication,4000
                );

        //when
        boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);

        //then
        assertThat(attemptResult).isFalse();
    }
}