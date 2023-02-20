package leetcode._26removeduplicatesfromsortedarray;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Remove Duplicates from Sorted Array")
class SolutionTest {

    private final Solution solution = new Solution();

    static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{1, 1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, new int[]{0, 1, 2, 3, 4})
        );
    }

    @ParameterizedTest(name = "{0}  -->  {1}")
    @MethodSource("arrayProvider")
    void removeDuplicates(int[] nums, int[] expectedNums) {
        int k = solution.removeDuplicates(nums); // Calls your implementation
        assertThat(k).isEqualTo(expectedNums.length);
        for (int i = 0; i < k; i++) {
            assertThat(nums[i]).isEqualTo(expectedNums[i]);
        }
    }
}
