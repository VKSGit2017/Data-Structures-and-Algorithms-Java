/*
143. Reorder List
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

https://leetcode.com/problems/reorder-list/description/

*/



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
    //Time Complexity - O(N), Space Complexity - O(1)
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow= head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse half list
        ListNode prev= null, cur = slow, next;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev= cur;
            cur= next;
        }

        //Merge 2 list
        ListNode firstP = head, secondP = prev, temp;
        while(secondP.next != null && firstP != null){
            temp = firstP.next;
            firstP.next = secondP;
            firstP = temp;

            temp = secondP.next;
            secondP.next = firstP;
            secondP= temp;
        }
    }
}
