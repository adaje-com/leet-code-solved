package leetcode._409longestpalindrome;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> characters = new HashSet<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characters.contains(c)) {
                characters.remove(c);
                count++;
            } else {
                characters.add(c);
            }
        }
        count *= 2;
        if (!characters.isEmpty()) {
            count++;
        }
        return count;
    }
}
