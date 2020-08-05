package microservices.book.multiplication.service;

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
public class RandomGeneratorServiceTest {

    RandomGeneratorService randomGeneratorService;

    @Test
    public void generateRandomFactorIsBetweenExpectedLimits(){
        //when a good sample of random generated factors is generated
        List<Integer> randomFactors = IntStream.range(0,1000)
                .map(i->randomGeneratorService.generateRandomFactor())
                .boxed().collect(Collectors.toList());
        // then all of them should be with in the range 11 to 100
        //because we need middle-complexity calculation
        assertThat(randomFactors).containsOnlyElementsOf(IntStream.range(11,100)
        .boxed().collect(Collectors.toList()));
    }
}