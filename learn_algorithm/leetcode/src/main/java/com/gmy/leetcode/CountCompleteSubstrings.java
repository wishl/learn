package com.gmy.leetcode;

/**
 * LeetCode 2953. Count Complete Substrings
 *
 * A substring is "complete" if:
 * 1. Each character in the substring occurs exactly k times.
 * 2. The absolute difference between adjacent characters' alphabet positions ≤ 2.
 */
public class CountCompleteSubstrings {

    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        int ans = 0;

        // Split into segments where adjacent characters differ by at most 2
        for (int i = 0; i < n; ) {
            int j = i + 1;
            while (j < n && Math.abs(word.charAt(j) - word.charAt(j - 1)) <= 2) {
                j++;
            }
            ans += countInSegment(word, i, j, k);
            i = j;
        }

        return ans;
    }

    private int countInSegment(String s, int start, int end, int k) {
        int len = end - start;
        int ans = 0;

        // Try all possible numbers of unique characters m (1 to 26)
        for (int m = 1; m <= 26 && m * k <= len; m++) {
            int windowSize = m * k;
            int[] count = new int[26];
            int validChars = 0;

            // Initialize first window - build counts then validate
            for (int i = start; i < start + windowSize; i++) {
                count[s.charAt(i) - 'a']++;
            }
            for (int c : count) {
                if (c == k) validChars++;
            }
            if (validChars == m) {
                ans++;
            }

            // Slide the window
            for (int i = start + windowSize; i < end; i++) {
                int outIdx = s.charAt(i - windowSize) - 'a';
                int inIdx = s.charAt(i) - 'a';

                // Remove outgoing character (handle both k→k-1 and k+1→k)
                if (count[outIdx] == k) validChars--;
                count[outIdx]--;
                if (count[outIdx] == k) validChars++;

                // Add incoming character (handle both k-1→k and k→k+1)
                if (count[inIdx] == k) validChars--;
                count[inIdx]++;
                if (count[inIdx] == k) validChars++;

                if (validChars == m) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        CountCompleteSubstrings solution = new CountCompleteSubstrings();

        System.out.println("Example 1: " + solution.countCompleteSubstrings("igigee", 2) + " (expected 3)");
        System.out.println("Example 2: " + solution.countCompleteSubstrings("aaabbbccc", 3) + " (expected 6)");

        // Additional test cases
        System.out.println("Single char repeated: " + solution.countCompleteSubstrings("aaa", 3) + " (expected 1)");
        System.out.println("All adjacent <= 2: " + solution.countCompleteSubstrings("abcd", 1) + " (expected 10)");
        System.out.println("Split by diff > 2: " + solution.countCompleteSubstrings("abxcd", 1) + " (expected 7)");
        // Test sliding past k boundary (k+1->k and k->k+1 transitions)
        System.out.println("Transition through k: " + solution.countCompleteSubstrings("aaaabbb", 3) + " (expected 4)");
        System.out.println("Slide through k both ways: " + solution.countCompleteSubstrings("aabc", 1) + " (expected 7)");
    }
}
