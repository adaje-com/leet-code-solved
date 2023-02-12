package leetcode._21mergesortedlists;

import leetcode.common.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = min(list1, list2);
        head.next = mergeTwoLists(head.next, max(list1, list2));
        return head;
    }

    private ListNode min(ListNode node1, ListNode node2) {
        return node1.val < node2.val ? node1 : node2;
    }

    private ListNode max(ListNode node1, ListNode node2) {
        return node1.val < node2.val ? node2 : node1;
    }
}
