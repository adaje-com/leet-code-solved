package leetcode._27removeelement;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@DisplayName("Remove Element")
class SolutionTest {

    private final Solution solution = new Solution();

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                Arguments.of(new int[]{1}, 0, new int[]{1}),
                Arguments.of(new int[]{1, 2}, 1, new int[]{2}),
                Arguments.of(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 0, 1, 3, 4})
        );
    }

    @ParameterizedTest(name = "{0} - {1} = {2}")
    @MethodSource("argumentProvider")
    void removeElement(int[] numbers, int value, int[] expected) {
        int k = solution.removeElement(numbers, value); // Calls your implementation
        Assertions.assertThat(k)
                .isEqualTo(expected.length);
        int[] firstKNumbers = Arrays.stream(numbers)
                .limit(k)
                .sorted()
                .toArray();
        for (int i = 0; i < firstKNumbers.length; i++) {
            Assertions.assertThat(firstKNumbers[i])
                    .isEqualTo(expected[i]);
        }
    }
}
