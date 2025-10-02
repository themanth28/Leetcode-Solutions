package linkedList.addTwoNumbersII;

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = reverse(l1);
        ListNode second = reverse(l2);
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        int carry = 0;
        int sum = 0;
        while(first!=null || second != null || carry != 0){
            if(first != null && second != null){
                sum = first.val + second.val + carry;
                first = first.next;
                second = second.next;
            }else if(first != null && second == null){
                sum = first.val + carry;
                first = first.next;
            }else if(second != null && first ==null){
                sum = second.val + carry;
                second = second.next;
            }else if(first == null && second == null){
                sum = carry;
            }
            int digit = sum%10;
            carry = sum/10;
            ListNode t = new ListNode(digit);
            ans.next = t;
            ans = ans.next;
        }
        ListNode sol = reverse(res.next);
        return sol;
    }

    public ListNode reverse(ListNode head){
        ListNode temp = null;
        ListNode currNode = head;
        ListNode prev = null;
        while(currNode != null){
            temp = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = temp;            
        }
        return prev;
    }
}