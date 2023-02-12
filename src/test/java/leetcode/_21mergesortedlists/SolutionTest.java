package leetcode._21mergesortedlists;

import leetcode.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Merge Two Sorted Lists")
class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void twoEmptyLists_AnswersEmptyList() {
        assertThat(solution.mergeTwoLists(null, null))
                .isEqualTo(null);
    }

    @Test
    void oneEmptyList_AnswersOtherList() {
        ListNode list = ListNode.of(new int[]{3, 4, 5});
        assertThat(solution.mergeTwoLists(null, list)).isEqualTo(list);
        assertThat(solution.mergeTwoLists(list, null)).isEqualTo(list);
    }

    @Test
    void twoSameList_AnswersSameTwice() {
        int[] numbers = {1};
        int[] expected = {1, 1};
        ListNode actualList = solution.mergeTwoLists(ListNode.of(numbers), ListNode.of(numbers));
        assertThat(actualList).isEqualTo(ListNode.of(expected));
    }

    @Test
    void singleNumberlists_AreSortedCorrectly() {
        int[] expected = {1, 2};
        assertThat(solution.mergeTwoLists(new ListNode(1), new ListNode(2))).isEqualTo(ListNode.of(expected));
        assertThat(solution.mergeTwoLists(new ListNode(2), new ListNode(1))).isEqualTo(ListNode.of(expected));
    }

    @Test
    void multiNumberLists_AreSortedCorrectly() {
        int[] one = {1, 5, 6, 9, 16};
        int[] two = {2, 2, 6, 21};
        int[] expected = {1, 2, 2, 5, 6, 6, 9, 16, 21};
        assertThat(solution.mergeTwoLists(ListNode.of(one), ListNode.of(two))).isEqualTo(ListNode.of(expected));
    }

    @Test
    void mergeIsTransitive() {
        int[] first = {1, 5, 9, 16};
        int[] second = {2, 2, 6, 21, 99};
        assertThat(solution.mergeTwoLists(ListNode.of(first), ListNode.of(second)))
                .isEqualTo(solution.mergeTwoLists(ListNode.of(second), ListNode.of(first)));
    }
}
