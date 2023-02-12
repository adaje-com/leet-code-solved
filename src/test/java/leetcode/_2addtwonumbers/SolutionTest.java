package leetcode._2addtwonumbers;

import leetcode.common.ListNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static leetcode.common.ListNode.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Add Two Numbers")
class SolutionTest {
    private final Solution solution = new Solution();

    @Test
    void zeroPlusANumber_IsSameNumber() {
        ListNode number = ListNode.of(new int[]{1, 3, 4});
        assertThat(solution.addTwoNumbers(ZERO, ZERO)).isEqualTo(ZERO);
        assertThat(solution.addTwoNumbers(number, ZERO)).isEqualTo(number);
        assertThat(solution.addTwoNumbers(ZERO, number)).isEqualTo(number);
    }

    @Test
    void onePlusOneIsTwo() {
        ListNode one = ListNode.of(new int[]{1});
        ListNode two = ListNode.of(new int[]{2});
        assertThat(solution.addTwoNumbers(one, one)).isEqualTo(two);
    }

    @Test
    void sixPlusSixIsTwelve() {
        ListNode six = ListNode.of(new int[]{6});
        ListNode twelve = ListNode.of(new int[]{2, 1});
        assertThat(solution.addTwoNumbers(six, six)).isEqualTo(twelve);
    }

    @Test
    void addUpColumns_NoCarryRequired() {
        ListNode number1 = ListNode.of(new int[]{1, 2, 3});
        ListNode number2 = ListNode.of(new int[]{4, 5, 6});
        ListNode expectedSum = ListNode.of(new int[]{5, 7, 9});
        assertThat(solution.addTwoNumbers(number1, number2)).isEqualTo(expectedSum);
    }

    @Test
    void addUpColumns_CarryRequired() {
        ListNode number1 = ListNode.of(new int[]{2, 4, 3});
        ListNode number2 = ListNode.of(new int[]{5, 6, 4});
        ListNode expectedSum = ListNode.of(new int[]{7, 0, 8});
        assertThat(solution.addTwoNumbers(number1, number2)).isEqualTo(expectedSum);
    }

    @Test
    void lotsOfNines_lotsOfCarries() {
        ListNode number1 = ListNode.of(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode number2 = ListNode.of(new int[]{9, 9, 9, 9});
        ListNode expectedSum = ListNode.of(new int[]{8, 9, 9, 9, 0, 0, 0, 1});
        assertThat(solution.addTwoNumbers(number1, number2)).isEqualTo(expectedSum);
    }
}
