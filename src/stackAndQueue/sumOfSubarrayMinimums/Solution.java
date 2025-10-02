package stackAndQueue.sumOfSubarrayMinimums;

import java.util.Stack;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int le = arr.length;
        int[] p = prev(arr);
        int[] n = next(arr);
        long ans = 0;
        for(int i=0; i<le; i++){
            long l = i-p[i];
            long r = n[i]-i;
            ans = (ans + arr[i] * l * r) % ((int) 1e9 + 7);
        }
        return (int) ans;
    }

    public int[] prev(int[] a){
        int n = a.length;
        int[] res = new int[n];

        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && a[s.peek()] > a[i]){
                s.pop();
            }
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        return res;
    }

    public int[] next(int[] a){
        int n = a.length;
        int[] res = new int[n];

        Stack<Integer> s = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!s.isEmpty() && a[s.peek()] >= a[i]){
                s.pop();
            }
            res[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        return res;
    }
}