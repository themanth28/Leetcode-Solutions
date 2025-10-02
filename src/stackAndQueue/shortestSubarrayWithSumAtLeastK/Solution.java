package stackAndQueue.shortestSubarrayWithSumAtLeastK;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        
        int n = nums.length;
        int res = n+1;
        long[] p = new long[n+1];

        for(int i=0; i<n; i++){
            p[i+1] = p[i] + nums[i];
        }

        for(int i=0; i<=n; i++){

            while(!q.isEmpty() && p[i] - p[q.peekFirst()] >= k){
                res = Math.min(i-q.peekFirst(), res);
                q.removeFirst();
            }

            while(!q.isEmpty() && p[i] <= p[q.peekLast()]){
                q.removeLast();
            }
            
            q.addLast(i);
        }

        return res <= n ? res : -1;
    }
}