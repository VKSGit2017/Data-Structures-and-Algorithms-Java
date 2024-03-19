/*
621. Task Scheduler
You are given an array of CPU tasks, each represented by letters A to Z, and a cooling time, n. Each cycle or interval allows the completion of one task. Tasks can be completed in any order, but there's a constraint: identical tasks must be separated by at least n intervals due to cooling time.

​Return the minimum number of intervals required to complete all tasks.

https://leetcode.com/problems/task-scheduler/description
*/



class Solution {
    //Time Complexity - O(26log26 + N) means O(N) and Spacec complaexity - O(26) means O(1)
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task:tasks){
            freq[task-'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25]-1;
        int idleSlots = maxFreq * n;

        for(int i=24; i>=0 && freq[i]>0 ; i--){
            idleSlots -= Math.min(maxFreq, freq[i]);
        }
        return idleSlots > 0? idleSlots + tasks.length : tasks.length;
    }
}
