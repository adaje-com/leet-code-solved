package leetcode._409longestpalindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("a", 1),
                Arguments.of("aa", 2),
                Arguments.of("aaa", 3),
                Arguments.of("abccccdd", 7),
                Arguments.of("aabbbbcccccc", 12),
                Arguments.of("abbccc", 5),
                Arguments.of("acccfffff", 7)
        );
    }

    @ParameterizedTest(name = "longestPalindrome({0}) = {1}")
    @MethodSource("argumentProvider")
    void longestPalindrome(String characters, int expected) {
        assertThat(solution.longestPalindrome(characters)).isEqualTo(expected);
    }
}
