package linkedList.findLengthOfLoop;
/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        // code here
        Node slow = head;
        Node fast = head;
        Node temp = null;
        int count = 1;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow == fast){
                temp=slow.next;
                while(temp!=slow){
                    temp = temp.next;
                    count++;
                }
                return count;
            }
        }
        return 0;
        
    }
}