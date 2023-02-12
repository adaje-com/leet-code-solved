package leetcode.common;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Arrays;
import java.util.PrimitiveIterator;

@ToString
@EqualsAndHashCode
public class ListNode {

    public static final ListNode ZERO = new ListNode();

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(int[] ints) {
        if (ints == null || ints.length == 0) {
            return null;
        }
        PrimitiveIterator.OfInt numbers = Arrays.stream(ints)
                .iterator();
        ListNode head = new ListNode(numbers.next());
        ListNode current = head;
        while (numbers.hasNext()) {
            current.next = new ListNode(numbers.next());
            current = current.next;
        }
        return head;
    }
}
