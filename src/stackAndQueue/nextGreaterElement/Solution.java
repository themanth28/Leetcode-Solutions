package stackAndQueue.nextGreaterElement;

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> s = new Stack<>();
        int[] sol = new int[arr.length];
        
        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && s.peek()<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                sol[i] = -1;
            }else{
                sol[i] = s.peek();
            }
            s.push(arr[i]);
        }
        
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0; i<sol.length; i++){
            a.add(sol[i]);
        }
        
        return a;
    }
}