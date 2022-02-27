package guru.qa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class IcqListTest {


    static Stream<Arguments> mixedArgumentsTestDataProvider() {
        return Stream.of(
                Arguments.of("Boys", List.of(2496068,13135432,67870098), " colleagues"),
                Arguments.of("Girls", List.of(49080815,84908528,777321456), " girlfriends")
        );
    }

    @MethodSource(value = "mixedArgumentsTestDataProvider")
    @ParameterizedTest(name = "Name {0}")
    void icqListTest(String firstArg, List<Integer> secondArg, String thirdArg) {
        System.out.println("String:" + firstArg + " icq: " + secondArg.toString() +  thirdArg);
    }
}
