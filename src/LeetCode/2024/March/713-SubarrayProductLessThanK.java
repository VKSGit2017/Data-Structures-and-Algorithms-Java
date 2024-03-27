/*
713. Subarray Product Less Than K
Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.

https://leetcode.com/problems/subarray-product-less-than-k/description/

*/


class Solution {
    //Time Complexity - O(N), Space Complexity - O(1)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if( k<=1 || nums.length == 0) return 0;

        int noOfSubarray = 0, product = 1;
        for(int start=0, end =0; end< nums.length; end++){
            product *= nums[end];

            while(product >= k){
                product /= nums[start++];
            }

            noOfSubarray += end-start+1;
        }
        return noOfSubarray;
    }
}
