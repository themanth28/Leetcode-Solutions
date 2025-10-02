package stackAndQueue.timeNeededToBuyTickets;// DP solution
// The Simple Rule: Everyone Buys One Ticket Per Turn
// The key is realizing that the process stops as soon as the person at k reaches their ticket limit, tickets[k].

// 1. People Before or At k (i≤k)
// These people get to buy a ticket in every cycle the line completes, up until k's final turn.

// They are limited by how many tickets k buys (tickets[k]).

// They are also limited by how many tickets they actually need (tickets[i]).

// We take the smallest of the two limits: min(tickets[i],tickets[k]).

// 2. People After k (i>k)
// These people are behind k. When k takes their final turn, the line stops before it gets back to them.

// Since k buys tickets[k] tickets in total, the people behind only participate in tickets[k]−1 full cycles.

// They are limited by their own need (tickets[i]).

// We take the smallest of the two limits: min(tickets[i],tickets[k]−1).

// The final answer is simply the sum of all these limited ticket counts for every person in the queue.

class DPAndGreedySolution {
    public int timeRequiredToBuy(int[] t, int k) {
        int total = 0;

        for(int i=0; i<t.length; i++){
            if(i<=k){
                total+= Math.min(t[i], t[k]);
            }else{
                total+= Math.min(t[i], t[k]-1);
            }
        }

        return total;

    }
}