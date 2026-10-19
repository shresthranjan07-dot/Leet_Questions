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
    public ListNode reverseList(ListNode head) {
        Stack <Integer> Vstack = new Stack<>();

        while (head != null){
            Vstack.push(head.val);
            head = head.next;
        }

        ListNode reverseList = new ListNode (Integer.MIN_VALUE);
        ListNode ptr = reverseList;

        while (! Vstack.isEmpty()){
            ptr.next = new ListNode (Vstack.pop());
            ptr = ptr.next;
        }
        return reverseList.next;
    }
}