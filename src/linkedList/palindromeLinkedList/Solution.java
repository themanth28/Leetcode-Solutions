package linkedList.palindromeLinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = findMiddle(head);

        ListNode secondHalfHead = reverseList(middle.next); 
        
        middle.next = null; 

        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean isPalindromic = true;

        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalindromic = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        ListNode originalSecondHalfHead = reverseList(secondHalfHead);
        middle.next = originalSecondHalfHead;

        return isPalindromic;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode nextNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}