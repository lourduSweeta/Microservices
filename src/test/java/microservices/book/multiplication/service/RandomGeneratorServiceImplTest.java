package microservices.book.multiplication.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomGeneratorServiceImplTest {
    private RandomGeneratorServiceImpl randomGeneratorServiceImpl;

    @Before
    public void setUp()
    {
        randomGeneratorServiceImpl = new RandomGeneratorServiceImpl();
    }

    @Test
    public void generateRandomFactorsIsBetweenExpectedLimits()
    {
        // when a good sample of generated factors is generated
        List<Integer> randomFactors = IntStream.range(0,1000)
                .map(i->randomGeneratorServiceImpl.generateRandomFactor())
                .boxed().collect(Collectors.toList());
        //then all random generated numbers should be  within limits 11 to 100
        //because we want the middle complexity calculation
        assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(11,100)
        .boxed().collect(Collectors.toList()));

    }
}