package leetcode.leetcode75;

import leetcode.common.ListNode;

import java.util.Map;
import java.util.stream.IntStream;

public class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + nums[i];
        }
        return nums;
    }

    public int[] runningSumUsingStreams(int[] nums) { //EXTRA
        return IntStream.range(0, nums.length)
                .map(i -> IntStream.rangeClosed(0, i)
                        .map(operand -> nums[operand])
                        .sum())
                .toArray();
    }

    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public boolean isIsomorphic(String s, String t) {
        for (var i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))) {
                return false;
            }
        }
        return true;
        //TODO: do space and time complexity on this and other solutions
//        assert s1.length() == s2.length();
//        if (s1.equals(s2)) {
//            return true;
//        }
//        Map<Character, Character> charMap = new HashMap();
//        for (int i = 0; i < s1.length(); i++) {
//            if (!isReplacedBy(charMap, s1.charAt(i), s2.charAt(i))) {
//                return false;
//            }
//        }
//        return true;
    }

    private boolean isReplacedBy(Map<Character, Character> charMap, char c1, char c2) {
        if (charMap.containsKey(c1)) {
            return charMap.get(c1) == c2; //c1 is a known replacement for c2
        }
        if (charMap.containsValue(c2)) {
            return false;  //c2 is replaced by another character
        }
        charMap.put(c1, c2); //c1 is a new replacement for c2
        return true;
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        int found = t.indexOf(s.charAt(0));
        if (found == -1) {
            return false;
        }
        return isSubsequence(s.substring(1), t.substring(found + 1));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode headOfReverse = null;
        while (head != null) {
            ListNode theRest = head.next;
            head.next = headOfReverse;
            headOfReverse = head;
            head = theRest;
        }
        return headOfReverse;
    }

    public ListNode reverseListUsingRecursion(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode rest = reverseListUsingRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middleNode = head;
        for (int i = 1; i <= length(head) / 2; i++) {
            middleNode = middleNode.next;
        }
        return middleNode;
    }

    public int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public ListNode middleNodeUsingTwoPointers(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int count = 1;
        ListNode middle = head;
        while (head != null) {
            count++;
            if (count % 2 == 1) {
                middle = middle.next;
            }
            head = head.next;
        }
        return middle;
    }
}
