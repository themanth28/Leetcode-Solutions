package graph.ShortestSubStrings;

import java.util.Arrays;
import java.util.TreeSet;

class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            String s = arr[i];
            int m = s.length();
            String best = "";

            // Try all substring lengths from 1 to m
            for (int len = 1; len <= m; len++) {
                TreeSet<String> candidates = new TreeSet<>(); // to auto-sort lexicographically

                // Generate all substrings of length len
                for (int start = 0; start + len <= m; start++) {
                    String sub = s.substring(start, start + len);
                    if (isUnique(sub, arr, i)) {
                        candidates.add(sub);
                    }
                }

                // If we found any unique substrings of this length, choose lexicographically smallest
                if (!candidates.isEmpty()) {
                    best = candidates.first();
                    break; // shortest found, stop searching
                }
            }

            result[i] = best;
        }

        return result;
    }

    // Helper: check if 'sub' exists in any other string except arr[idx]
    private boolean isUnique(String sub, String[] arr, int idx) {
        for (int i = 0; i < arr.length; i++) {
            if (i != idx && arr[i].contains(sub)) {
                return false;
            }
        }
        return true;
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] arr = {"cab", "ad", "bad", "c"};
        System.out.println(Arrays.toString(sol.shortestSubstrings(arr)));
        // Output: [ab, "", ba, ""]
    }
}
