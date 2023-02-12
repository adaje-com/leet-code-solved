package leetcode._9palindromenumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Palindrome Number Test")
class SolutionTest {
    @Test
    void aSingleDigitNumber_IsAPalidrome() {
        assertThat(new Solution().isPalindrome(5)).isTrue();
    }

    @Test
    void aNegativeNumber_IsNeverAPalindrome() {
        assertThat(new Solution().isPalindrome(-121)).isFalse();
    }

    @Test
    void aNumberWithAllSameDigits_IsAPalindrome() {
        assertThat(new Solution().isPalindrome(33)).isTrue();
    }

    @Test
    void theNumber_121_IsAPalindrome() {
        assertThat(new Solution().isPalindrome(121)).isTrue();
    }

    @Test
    void theNumber_3443_IsAPalindrome() {
        assertThat(new Solution().isPalindrome(3443)).isTrue();
    }

    @Test
    void theNumber_55655_IsAPalindrome() {
        assertThat(new Solution().isPalindrome(55655)).isTrue();
    }
}
