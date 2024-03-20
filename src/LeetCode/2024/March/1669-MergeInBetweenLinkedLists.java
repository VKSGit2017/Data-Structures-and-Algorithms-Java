
/*
1669. Merge In Between Linked Lists

You are given two linked lists: list1 and list2 of sizes n and m respectively.
Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
Build the result list and return its head.
https://leetcode.com/problems/merge-in-between-linked-lists/description/
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
    // Time Complexity - O(N+M) Space complexity - O(1)
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode cur = list1, prev = null, next, mergeStart = null, mergeEnd = null;
        int cnt =0;
        while(cur != null){
            cnt++;
            if(cnt == a+1){
                mergeStart = prev;
            }
            if(cnt == b+1){
                mergeEnd = cur != null?cur.next:cur;
                break;
            }
            prev = cur;
            cur = cur.next;
        }
        cur = list2;
        while(cur.next != null){
            cur = cur.next;
        }
        if(mergeStart != null){
            mergeStart.next = list2;
            cur.next = mergeEnd;
        }
        return list1;
    }
}
