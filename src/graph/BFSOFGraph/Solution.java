package graph.BFSOFGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // Function to return a list containing the BFS traversal of the graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        // Start BFS from vertex 0
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            // Traverse all adjacent vertices (in given order)
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }
}