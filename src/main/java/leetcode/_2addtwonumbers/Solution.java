package leetcode._2addtwonumbers;

import leetcode.common.ListNode;

public class Solution {

    public ListNode addTwoNumbers(ListNode number1, ListNode number2) {
        return addTwoNumbers(number1, number2, 0);
    }

    private ListNode addTwoNumbers(ListNode number1, ListNode number2, int carry) {
        if (number1 == null && number2 == null && carry == 0) {
            return null;
        }
        int sumDigits = firstDigit(number1) + firstDigit(number2) + carry;
        ListNode sum = new ListNode(sumDigits % 10);
        sum.next = addTwoNumbers(remainingDigits(number1), remainingDigits(number2), sumDigits / 10);
        return sum;
    }

    private int firstDigit(ListNode number) {
        return number != null ? number.val : 0;
    }

    private ListNode remainingDigits(ListNode number) {
        return number != null ? number.next : null;
    }
}
