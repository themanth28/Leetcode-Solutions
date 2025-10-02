package stackAndQueue.celebrityProblem;

import java.util.Stack;

class Solution {
    public int celebrity(int mat[][]) {
        // code here
        Stack<Integer> s = new Stack<>();
        int[] arr = new int[mat.length];
        
        for(int i=0; i<mat.length; i++){
            s.push(i);
        }
        
        
        while(s.size()>=2){
            int a = s.pop();
            int b = s.pop();
            
            if(know(mat,a,b)){
                s.push(b);
            }else{
                s.push(a);
            }
        }
        
        if (s.isEmpty()) {
            return -1;
        }
        
        int candidate = s.pop();
        
        for(int i=0; i<mat.length; i++){
            if(i==candidate){
                continue;
            }
            
            if(!know(mat,i,candidate)){
                return -1;
            }
            
            if(know(mat,candidate,i)){
                return -1;
            }
        }
        
        return candidate;
        
    }
    
    public boolean know(int[][] mat, int a, int b){
        return mat[a][b] == 1;
    }
}