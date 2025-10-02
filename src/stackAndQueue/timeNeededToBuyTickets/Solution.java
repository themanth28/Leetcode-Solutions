package stackAndQueue.timeNeededToBuyTickets;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q1 = new LinkedList<Integer>();

        for(int i=0; i<tickets.length; i++){
            q1.add(i);
        }
        int time = 0;

        while(!q1.isEmpty()){
            int c = q1.poll();
            time++;
            tickets[c]--;
            if(c == k && tickets[k]==0){
                return time;
            }
            if(tickets[c]>0)
                q1.offer(c);
        }

        return 0;


    }
}