package leetcode._20validparentheses;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("ValidParentheses")
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void emptyString_IsValid() {
        assertThat(solution.isValid("")).isTrue();
    }

    @Test
    void anyOddString_IsInvalid() {
        assertThat(solution.isValid("{")).isFalse();
        assertThat(solution.isValid("[](")).isFalse();
        assertThat(solution.isValid("([{])")).isFalse();
    }

    @Test
    void nestedPairs_IsInvalid() {
        assertThat(solution.isValid("{{}}")).isTrue();
        assertThat(solution.isValid("[{()}]")).isTrue();
        assertThat(solution.isValid("[{}]()")).isTrue();
    }

    @Test
    void singlePairInCorrectOrder_IsValid() {
        assertThat(solution.isValid("()")).isTrue();
        assertThat(solution.isValid("[]")).isTrue();
        assertThat(solution.isValid("{}")).isTrue();
    }

    @Test
    void missingClosing_IsInvalid() {
        assertThat(solution.isValid("((")).isFalse();
        assertThat(solution.isValid("[{]{")).isFalse();
    }

    @Test
    void wrongOrder_IsInvalid() {
        assertThat(solution.isValid("[{]}")).isFalse();
    }

    @Test
    void singlePairInWrongOrder_IsInvalid() {
        assertThat(solution.isValid(")(")).isFalse();
        assertThat(solution.isValid("][")).isFalse();
        assertThat(solution.isValid("}{")).isFalse();
    }

    @Test
    void multiplePairsInCorrectOrder_IsValid() {
        assertThat(solution.isValid("()[]{}")).isTrue();
        assertThat(solution.isValid("[][]")).isTrue();
    }
}
