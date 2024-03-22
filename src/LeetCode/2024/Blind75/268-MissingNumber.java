/*
268. Missing Number

Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

https://leetcode.com/problems/missing-number/description/
*/


class Solution {
    //Time Complexity = O(N), Space Complexity - O(1)
    public int missingNumber(int[] nums) {
        int num = nums.length;
        int sum = num*(num +1)/2;
        int curSum = 0;
        for(int ele:nums){
            curSum += ele;
        }
        return sum-curSum;
    }
}
