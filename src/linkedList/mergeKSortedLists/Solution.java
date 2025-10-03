package linkedList.mergeKSortedLists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> p = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        for(ListNode n : lists){
            if(n!=null){
                p.add(n);
            }            
        } 

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while(!p.isEmpty()){
            ListNode c = p.poll();  
            cur.next = c;
            cur = cur.next;

            if(c.next != null){
                p.offer(c.next);
            }
        }     
        return head.next;
    }
}