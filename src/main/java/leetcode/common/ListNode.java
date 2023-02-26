package leetcode.common;

import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.PrimitiveIterator;

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

    public String toString() {
        //TODO: this results in an infinite loop for a circular list; fix it
        StringBuilder builder = new StringBuilder();
        builder.append(val);
        int count = 1; //only print up to 20...
        ListNode nextNode = this.next;
        while (nextNode != null && count <= 6) {
            builder.append(",")
                    .append(nextNode.val);
            nextNode = nextNode.next;
            count++;
        }
        return builder.toString();
    }
}
