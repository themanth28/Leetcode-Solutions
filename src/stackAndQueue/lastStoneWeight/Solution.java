package stackAndQueue.lastStoneWeight;

import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b-a);

        for(int i=0; i<stones.length; i++){
            heap.add(stones[i]);
        }

        while(heap.size()>1){
            int t1 = heap.poll();
            int t2 = heap.poll();
            int diff = Math.abs(t1-t2);

            if(diff!=0){
                heap.add(diff);
            }
        }

        if(heap.size()!=0){
            return heap.poll();
        }else{
            return 0;
        }
    }
}