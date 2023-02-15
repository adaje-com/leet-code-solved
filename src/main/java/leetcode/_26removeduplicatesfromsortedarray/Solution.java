package leetcode._26removeduplicatesfromsortedarray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums.length;
        }
        int i = 0, k = 1;
        int currentUniqueNum = nums[0], nextNumber;
        while (i < nums.length - 1) {
            nextNumber = nums[++i];
            if (nextNumber != currentUniqueNum) {
                nums[k++] = nextNumber;
                currentUniqueNum = nextNumber;
            }
        }
        return k;
    }
}
