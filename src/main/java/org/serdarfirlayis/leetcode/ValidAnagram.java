package org.serdarfirlayis.leetcode;

/**
 * LeetCode 242 - Valid Anagram
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            alphabet[t.charAt(i) - 'a']--;
        }

        for (int count : alphabet) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
