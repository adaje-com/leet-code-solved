package leetcode._14longestcommonprefix;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Longest Common Prefix")
class SolutionTest {
    Solution solution = new Solution();

    @Test
    void anEmptyListOfWordsHasNoCommonPrefix() {
        String[] emptyArray = {};
        assertThat(solution.longestCommonPrefix(emptyArray))
                .as("Should answer empty string")
                .isEqualTo("");
    }

    @Test
    void aListOfOneWord_HasACommonPrefixOfThatWord() {
        assertThat(solution.longestCommonPrefix(new String[]{"aa"}))
                .as("Should answer 'a'")
                .isEqualTo("aa");
    }

    @Test
    void aListOfAllSameSingleLetterWords_HasCommonPrefixOfThatLetter() {
        assertThat(solution.longestCommonPrefix(new String[]{"d", "d", "d"}))
                .as("Should answer 'd'")
                .isEqualTo("d");
    }

    @Test
    void aListOfDifferentSingleLetterWords_HasNoCommonPrefix() {
        assertThat(solution.longestCommonPrefix(new String[]{"d", "e", "f"}))
                .as("Should answer empty string")
                .isEqualTo("");
    }

    @Test
    void aListOfWordsAllStartingWithADifferentLetter_HasNoCommonPrefix() {
        assertThat(solution.longestCommonPrefix(new String[]{"dog", "racedog", "carrace"}))
                .as(" Should answer empty string.")
                .isEqualTo("");
    }

    @Test
    void aListOfWordsStartingWith_fl_HasCommonPrefix_fl() {
        assertThat(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}))
                .as(" Should answer common prefix 'fl'")
                .isEqualTo("fl");
    }

    @Test
    void aListOfAllSameWord_HasCommonPrefixEqualToThatWord() {
        assertThat(solution.longestCommonPrefix(new String[]{"word", "word", "word"}))
                .as(" Should answer 'word'")
                .isEqualTo("word");
    }

    @Test
    void aListOfWordsUsingASingleLetter_WillHaveACommonPrefixOfTheShortestWord() {
        assertThat(solution.longestCommonPrefix(new String[]{"aaa", "aa", "aaaaa"}))
                .as(" Should answer 'aa'")
                .isEqualTo("aa");
    }
}
