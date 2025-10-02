package stackAndQueue.maximumSlidingWindow;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i=0; i<n; i++){
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.removeLast();
            }

            q.addLast(i);

            if(q.peekFirst() == i-k){
                q.removeFirst();
            }

            if(i>= k-1){
                res[i-k+1] = nums[q.peekFirst()];
            }
        }

        return res;
    }
}