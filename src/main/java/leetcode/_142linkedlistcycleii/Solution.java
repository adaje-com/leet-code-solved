package leetcode._142linkedlistcycleii;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private static ListNode startOfLoop(ListNode loop, ListNode head) {
        while (head != loop) {
            head = head.next;
            loop = loop.next;
        }
        return head;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode tortoise = head, hare = head;
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return startOfLoop(tortoise, head);
            }
        }
        return null;
    }

    public ListNode detectCycleUsingSet(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> traversed = new HashSet<>();
        while (head != null) {
            if (traversed.contains(head)) {
                return head;
            }
            traversed.add(head);
            head = head.next;
        }
        return null;
    }
}
