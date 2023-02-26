package leetcode._121besttimetobuyandsellstock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("121. Best Time to Buy and Sell Stock")
class SolutionTest {

    private final Solution solution = new Solution();

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{6}, 0),
                Arguments.of(new int[]{100, 200}, 100),
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0)
        );
    }

    @ParameterizedTest(name = "maxProfit({0}) = {1}")
    @MethodSource("argumentProvider")
    void maxProfit(int[] prices, int expected) {
        Assertions.assertThat(solution.maxProfit(prices))
                .isEqualTo(expected);
    }
}

