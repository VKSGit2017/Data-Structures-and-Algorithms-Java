
/* LeetCode
525. Contiguous Array
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
https://leetcode.com/problems/contiguous-array/description/
*/

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0, maxLen = 0;
        for(int i = 0; i<nums.length; i++){
            count = count + (nums[i] == 1 ? 1 : -1);
            if(map.containsKey(count)){
                maxLen = Math.max(maxLen, i-map.get(count));
            }else{
                map.put(count, i);
            }
        }
        return maxLen;
    }
}
