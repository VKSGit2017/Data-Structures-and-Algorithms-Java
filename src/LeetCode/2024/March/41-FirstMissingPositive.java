/*
41. First Missing Positive
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
https://leetcode.com/problems/first-missing-positive/description/

*/


class Solution {
    //Time Complexity - O(n), Space Complexity - O(n) - using nums array so space is o(n)
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        boolean contains1 = false;

        for(int i = 0; i<len ; i++){
            if(nums[i] == 1){
                contains1 = true;
            }
            if(nums[i] <=0 || nums[i] > len){
                nums[i] = 1;
            }
        }

        if(!contains1) return 1;

        for(int i = 0; i<len; i++){
            int val = Math.abs(nums[i]);
            if(val == len){
                nums[0] = - Math.abs(nums[0]);
            }
            else{
                nums[val] = - Math.abs(nums[val]);
            }
        }

        for(int i = 1; i<len; i++){
            if(nums[i] > 0){
                return i;
            }
        }

        if(nums[0] > 0){
            return len;
        }
        return len+1;
    }
}
