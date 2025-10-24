package graph.DFSOfGraph;

import java.util.ArrayList;

class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();  // total number of vertices
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfsUtil(0, adj, visited, result);  // start DFS from vertex 0

        return result;
    }

    // Helper recursive DFS function
    private void dfsUtil(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;         // mark current node as visited
        result.add(node);             // add to result

        for (int neighbor : adj.get(node)) {   // visit all connected vertices
            if (!visited[neighbor]) {
                dfsUtil(neighbor, adj, visited, result);
            }
        }
    }
}