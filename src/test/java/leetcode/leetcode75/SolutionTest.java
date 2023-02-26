package leetcode.leetcode75;

import leetcode.common.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Leet Code 75")
class SolutionTest {

    private final Solution solution = new Solution();

    static Stream<Arguments> runningSumArgumentProvider() {
        return Stream.of(
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{1}, new int[]{1}),
                Arguments.of(new int[]{1, 2}, new int[]{1, 3}),
                Arguments.of(new int[]{3, 1, 2, 10, 1}, new int[]{3, 4, 6, 16, 17})
        );
    }

    static Stream<Arguments> pivotIndexArgumentProvider() {
        return Stream.of(
                Arguments.of(new int[]{1}, 0),
                Arguments.of(new int[]{1, 2, 3}, -1),
                Arguments.of(new int[]{1, 2, 1}, 1),
                Arguments.of(new int[]{1, 7, 3, 6, 5, 6}, 3),
                Arguments.of(new int[]{2, 1, -1}, 0),
                Arguments.of(new int[]{-5, 1, 4, 1}, 3)
        );
    }

    static Stream<Arguments> isIsomorphicArgumentProvider() {
        return Stream.of(
                Arguments.of("", "", 1),
                Arguments.of("egg", "add", 1),
                Arguments.of("paper", "title", 1),
                Arguments.of("122", "123", 0),
                Arguments.of("eggos", "added", 0),
                Arguments.of("papermoon", "titleside", 0)
        );
    }

    static Stream<Arguments> isSubsequenceArgumentProvider() {
        return Stream.of(
                Arguments.of("", "", 1),
                Arguments.of("", "abc", 1),
                Arguments.of("a", "abc", 1),
                Arguments.of("abc", "ahbgdc", 1),
                Arguments.of("abc", "", 0),
                Arguments.of("axc", "ahbgdc", 0),
                Arguments.of("ahbgdc", "ahb", 0),
                Arguments.of("bb", "ahbgdc", 0)
        );
    }

    static Stream<Arguments> reverseListArgumentProvider() {
        return Stream.of(
                Arguments.of(ListNode.of(new int[]{}), ListNode.of(new int[]{})),
                Arguments.of(ListNode.of(new int[]{1}), ListNode.of(new int[]{1})),
                Arguments.of(ListNode.of(new int[]{1, 2}), ListNode.of(new int[]{2, 1})),
                Arguments.of(ListNode.of(new int[]{3, 1, 6}), ListNode.of(new int[]{6, 1, 3})),
                Arguments.of(ListNode.of(new int[]{1, 2, 1}), ListNode.of(new int[]{1, 2, 1})),
                Arguments.of(ListNode.of(new int[]{5, 4, 3, 2, 1}), ListNode.of(new int[]{1, 2, 3, 4, 5}))
        );
    }

    static Stream<Arguments> middleNodeArgumentProvider() {
        return Stream.of(
                Arguments.of(ListNode.of(new int[]{}), ListNode.of(new int[]{})),
                Arguments.of(ListNode.of(new int[]{1}), ListNode.of(new int[]{1})),
                Arguments.of(ListNode.of(new int[]{1, 2}), ListNode.of(new int[]{2})),
                Arguments.of(ListNode.of(new int[]{3, 1, 6}), ListNode.of(new int[]{1, 6})),
                Arguments.of(ListNode.of(new int[]{1, 2, 3, 4, 5, 6}), ListNode.of(new int[]{4, 5, 6}))
        );
    }


    @DisplayName("1480. Running Sum of 1d Array")
    @ParameterizedTest(name = "runningSum({0}) = {1}")
    @MethodSource("runningSumArgumentProvider")
    void runningSum(int[] numbers, int[] expected) {
        Assertions.assertThat(solution.runningSum(numbers))
                .isEqualTo(expected);
    }

    @DisplayName("724. Find Pivot Index")
    @ParameterizedTest(name = "pivotIndex({0}) = {1}")
    @MethodSource("pivotIndexArgumentProvider")
    void pivotIndex(int[] numbers, int expected) {
        Assertions.assertThat(solution.pivotIndex(numbers))
                .isEqualTo(expected);
    }

    @DisplayName("205. Isomorphic Strings")
    @ParameterizedTest(name = "\"{0}\" and \"{1}\" {2,choice,0#are not|1#are} isomorphic")
    @MethodSource("isIsomorphicArgumentProvider")
    void isIsomorphic(String s, String t, int expected) {
        Assertions.assertThat(solution.isIsomorphic(s, t))
                .isEqualTo(expected != 0);
    }

    @DisplayName("392. Is Subsequence")
    @ParameterizedTest(name = "\"{0}\" {2,choice,0#is not|1#is} a subsequence of \"{1}\"")
    @MethodSource("isSubsequenceArgumentProvider")
    void isSubsequence(String s, String t, int expected) {
        boolean expectedResult = expected != 0;
        Assertions.assertThat(solution.isSubsequence(s, t))
                .isEqualTo(expectedResult);
    }

    @DisplayName("206. Reverse Linked List")
    @ParameterizedTest(name = "\"{0}\" reversed = \"{1}\"")
    @MethodSource("reverseListArgumentProvider")
    void reverseList(ListNode list, ListNode expected) {
        Assertions.assertThat(solution.reverseList(list))
                .isEqualTo(expected);
    }

    @DisplayName("206. Reverse Linked List Using Recursion")
    @ParameterizedTest(name = "\"{0}\" reversed = \"{1}\"")
    @MethodSource("reverseListArgumentProvider")
    void reverseListUsingRecursion(ListNode list, ListNode expected) {
        Assertions.assertThat(solution.reverseListUsingRecursion(list))
                .isEqualTo(expected);
    }

    @DisplayName("876. Middle of the Linked List Using 1 Pointer")
    @ParameterizedTest(name = "middleNode(\"{0}\") = \"{1}\"")
    @MethodSource("middleNodeArgumentProvider")
    void middleNode(ListNode list, ListNode expected) {
        Assertions.assertThat(solution.middleNode(list))
                .isEqualTo(expected);
    }

    @DisplayName("876. Middle of the Linked List Using 2 Pointers")
    @ParameterizedTest(name = "middleNode(\"{0}\") = \"{1}\"")
    @MethodSource("middleNodeArgumentProvider")
    void middleNodeUsingTwoPointers(ListNode list, ListNode expected) {
        Assertions.assertThat(solution.middleNodeUsingTwoPointers(list))
                .isEqualTo(expected);
    }
}
