/**

Given a string s, find the longest palindromic substring in s.
 You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"


**/

class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.trim().equals("")) return s;

        int len = s.length();
        int start = 0;
        int max = 0;
        for (int i = 0; i < len - max/2 ; i++) {
            int l = i; int r = i;
            while (r < len - 1 && s.charAt(r) == s.charAt(r + 1)) {
                r++;
            }
            while (l > 0 && l < len - 1 && s.charAt(l - 1) == s.charAt(r + 1)) {
                l--;
                r++;
            }
            if (r - l + 1 > max) {
                max = r - l + 1;
                start = l;
            }
        }
        return s.substring(start, start + max);
    }

}
