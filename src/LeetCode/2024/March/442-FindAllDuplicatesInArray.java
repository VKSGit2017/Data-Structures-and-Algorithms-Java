/*
442. Find All Duplicates in an Array
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.
https://leetcode.com/problems/find-all-duplicates-in-an-array/description/

*/



class Solution {
    //Time complexity - O(n), Space complexity - O(1), Aux Space used - 0(1)
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int num: nums){
            if(nums[Math.abs(num)-1] < 0){
                result.add(Math.abs(num));
            }
            nums[Math.abs(num)-1] *= -1;
        }
        return result;
    }
}
