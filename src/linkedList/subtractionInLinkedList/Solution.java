package linkedList.subtractionInLinkedList;/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    static Node subLinkedList(Node head1, Node head2) {
        // code here
        Node small = compare(head1, head2);
//        print(small);
        Node big = null;
        if(small==head1){
            big = head2;
        }else{
            big = head1;
        }
//        print(small);
//        print(big);
        Node res = new Node(-1);
        Node ans = res;
        Node sR = reverse(small);
        Node bR = reverse(big);
        int borrow = 0; // Renamed carry to borrow for clarity

        while(bR != null){
            int valS = 0; // Digit from small (subtrahend)
            int valB = bR.data; // Digit from big (minuend)

            if (sR != null) {
                valS = sR.data;
            }

            // Apply previous borrow to the current digit of the big number
            valB = valB - borrow;

            int resultDigit;

            if (valB >= valS) {
                // Subtraction is straight-forward, no borrow needed for next step
                resultDigit = valB - valS;
                borrow = 0;
            } else {
                // Subtraction requires borrowing from the next digit
                // Add 10 to valB to perform subtraction
                resultDigit = (valB + 10) - valS;
                borrow = 1; // Set borrow for the next digit
            }

            // Build the result list (LSB first)
            ans.next = new Node(resultDigit);
            ans = ans.next;

            if (sR != null) {
                sR = sR.next;
            }
            bR = bR.next;
        }

        Node finalResultHead = res.next;
        
        // Logic to remove trailing zeros from the LSB list (which are leading zeros in MSB list)
        Node current = finalResultHead;
        Node lastNonZero = null;

        // Traverse the LSB list to find the last node that is not zero
        while(current != null){
            if(current.data != 0){
                lastNonZero = current;
            }
            current = current.next;
        }

        if (lastNonZero != null) {
            // Trim the list after the last non-zero node
            lastNonZero.next = null;
            // finalResultHead remains the head of the trimmed list
        } else {
            // If lastNonZero is null, the entire result was 0
            return new Node(0);
        }

        return reverse(finalResultHead);
        
    }
    
    static Node reverse(Node head) {
        Node temp = null;
        Node current = head;
        Node prev = null;
        while(current != null){
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    private static int getLength(Node head) {
        int len = 0;
        Node current = head;
        while (current != null) {
            len++;
            current = current.next;
        }
        return len;
    }

    static Node compare(Node head1, Node head2){
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        // 1. Length Comparison (Shorter list is numerically smaller)
        if (len1 < len2) {
            return head1;
        }
        if (len2 < len1) {
            return head2;
        }

        // 2. Lexicographical Comparison (Only if lengths are equal)
        Node t1 = head1;
        Node t2 = head2;

        while(t1 != null){ // Since lengths are equal, we only need to check t1
            if(t1.data < t2.data){
                return head1;
            }else if(t2.data < t1.data){
                return head2;
            }

            t1=t1.next;
            t2=t2.next;
        }

        // Lists are identical in value and length
        return head1;
    }
    
}