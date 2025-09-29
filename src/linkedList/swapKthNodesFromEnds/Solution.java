package linkedList.swapKthNodesFromEnds;

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
    public Node swapKth(Node head, int k) {
        if (head == null) return null;

        Node prev1 = null;
        Node current = head;
        for (int i = 1; i < k; i++) {
            if (current == null) return head;
            prev1 = current;
            current = current.next;
        }
        Node node1 = current;

        Node prev2 = null;
        Node slow = head;
        Node fast = head;

        for(int i = 0; i < k; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }

        while(fast != null) {
            prev2 = slow;
            slow = slow.next;
            fast = fast.next;
        }
        Node node2 = slow;
        
        if (node1 == node2) {
            return head;
        }
        
        if (prev1 == null) {
            head = node2;
        } else if (prev2 == null) {
            head = node1;
        }

        if (prev1 != null) {
            prev1.next = node2;
        }
        if (prev2 != null) {
            prev2.next = node1;
        }
        
        Node tempNext = node1.next;
        
        if (node1.next == node2) {
            node1.next = node2.next;
            node2.next = node1;
        } else if (node2.next == node1) {
            node2.next = node1.next;
            node1.next = node2;
        } else {
            node1.next = node2.next;
            node2.next = tempNext;
        }

        return head;
    }
}
