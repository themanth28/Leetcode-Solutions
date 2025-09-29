package linkedList.flattenMultilevelDoublyLinkedList;/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null){
            return null;
        }
        Node temp = head;
        List<Node> nex = new ArrayList<>();
        while(temp!=null){
            if(temp.child!=null){
                // Node headT = temp;
                if(temp.next!=null){
                    nex.add(temp.next);
                }
                helper(temp);
                // temp = headT;
                continue;
            }
            if(!nex.isEmpty() && temp.next==null){
                temp.next = nex.get(nex.size()-1);
                nex.get(nex.size()-1).prev = temp;
                nex.remove(nex.size()-1);
            }

            temp = temp.next;
        }
        return head;
    }
    public void helper(Node temp){
        temp.next = temp.child;
        temp.child = null;
        temp.next.prev = temp;
        temp = temp.next;
        // while(temp.next!=null){
        //     temp = temp.next;
        // }
        // if(nex!=null){
        //     temp.next = nex;
        //     nex.prev = temp;
        // }
    }
}