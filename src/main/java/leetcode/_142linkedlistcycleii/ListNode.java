package leetcode._142linkedlistcycleii;

import java.util.HashMap;
import java.util.Map;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int[] number) {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(ListNode... nodes) {
        ListNode head = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            nodes[i - 1].next = nodes[i];
        }
        return head;
    }

    public static ListNode of(int... numbers) {
        ListNode[] nodes = new ListNode[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nodes[i] = new ListNode(numbers[i]);
        }
        return ListNode.of(nodes);
    }

    public String toString() {
        int index = 0;
        ListNode current = this;
        Map<ListNode, Integer> traversedByIndex = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        traversedByIndex.put(current, index);
        builder.append(current.val);
        while (current.next != null) {
            current = current.next;
            index++;
            if (traversedByIndex.containsKey(current)) {
                builder.append("->");
                builder.append(traversedByIndex.get(current));
                builder.append("]");
                return builder.toString();
            }
            builder.append(",")
                    .append(current.val);
            traversedByIndex.put(current, index);
        }
        builder.append("]");
        return builder.toString();
    }
}
