package leetcode._14longestcommonprefix;

class Solution {
    public String longestCommonPrefix(String[] words) {
        if (words.length == 0) {
            return "";
        }
        String prefix = words[0];
        for (int i = 1; i < words.length; i++) {
            prefix = longestCommonPrefix(prefix, words[i]);
            if (prefix == null) return "";
        }
        return prefix;
    }

    private String longestCommonPrefix(String word1, String word2) {
        String prefix = word1;
        while (!word2.startsWith(prefix)) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return null;
        }
        return prefix;
    }
}
