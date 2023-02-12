package leetcode._9palindromenumber;

class Solution {
    public boolean isPalindrome(int number) {
        return isPalindromeWithoutUsingStrings(number);
    }

//    public boolean isPalindromeUsingStrings(int number) {
//        String numberString = number + "";
//        return (number + "").equals(new StringBuilder(numberString).reverse()
//                .toString());
//    }

    public boolean isPalindromeWithoutUsingStrings(int number) {
        if (number < 0) {
            return false;
        }
        int remainder = number, reverse = 0;
        while (remainder > 0) {
            reverse = reverse * 10 + remainder % 10;
            remainder /= 10;
        }
        return number == reverse;
    }
}
