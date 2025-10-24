package graph.ShortestDistanceToReachXY;// User function Template for Java

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        // int[][] res = new int[N][M];
        if (A[0][0] == 0 || A[X][Y] == 0)
            return -1;
            
            
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[] {0,0,0});
        visited[0][0] = true;
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            int x = curr[0], y = curr[1], d = curr[2];
            
            if(x==X && y==Y){
                return d;
            }
            
            for(int i=0; i<4; i++){
                int a = x+dx[i];
                int b = y+dy[i];
                
                if(a>=0 && a<N && b>=0 && b<M && A[a][b] == 1 && !visited[a][b]){
                    visited[a][b] = true;
                    q.offer(new int[] {a,b,d+1});
                }
            }
            
        }
        return -1;
        
    }
};