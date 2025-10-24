package graph.DistanceOfNearestHaving1;

import java.util.*;

class Solution {
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Initialize queue with all 1's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        // Step 2: BFS directions (up, down, left, right)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Step 3: BFS traversal
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1], d = curr[2];
            dist[i][j] = d;

            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];

                if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                    visited[x][y] = true;
                    q.offer(new int[]{x, y, d + 1});
                }
            }
        }

        return dist;
    }
}
