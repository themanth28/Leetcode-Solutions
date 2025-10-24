package graph.TownJudge;

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n+1]; // 1-based indexing

        for (int[] t : trust) {
            int a = t[0], b = t[1];
            score[a]--; // a trusts someone → cannot be judge
            score[b]++; // b is trusted → increase score
        }

        for (int i = 1; i <= n; i++) {
            if (score[i] == n - 1) {
                return i; // this person is trusted by everyone else
            }
        }

        return -1; // no judge found
    }
}
