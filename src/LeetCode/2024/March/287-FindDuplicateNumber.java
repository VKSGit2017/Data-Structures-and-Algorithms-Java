/*
287. Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.

https://leetcode.com/problems/find-the-duplicate-number/description/
*/


class Solution {
    //Time Complexity - O(N), Spcae Complexity - O(1)
    public int findDuplicate(int[] nums) {
        int slow= nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(fast != slow);

        slow = nums[0];
        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
