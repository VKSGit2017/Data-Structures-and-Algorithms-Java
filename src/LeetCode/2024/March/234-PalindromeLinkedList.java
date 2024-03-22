/*
234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome  or false otherwise.
https://leetcode.com/problems/palindrome-linked-list/description/
 


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
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        ListNode firstHalfEnd = endOfFirstHalfPal(head);
        ListNode secondaHalfStart = reverseList(firstHalfEnd.next);

        ListNode p1Start = head, p2Start= secondaHalfStart;
        boolean result = true;
        while(result && p2Start!= null){
            if(p1Start.val != p2Start.val) result = false;
            p1Start = p1Start.next;
            p2Start = p2Start.next;
        }

        firstHalfEnd.next = reverseList(secondaHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head){
        ListNode cur = head, prev = null, next;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev=cur;
            cur = next;
        }
        return prev;
    }

    private ListNode endOfFirstHalfPal(ListNode head){
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
