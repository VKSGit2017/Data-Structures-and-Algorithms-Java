
/*
1137. N-th Tribonacci Number  - Easy

The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.
https://leetcode.com/problems/n-th-tribonacci-number/description/
*/

/*

Time complexity: O(n)

We have to update the value of a, b and c by n - 2 times, each update takes constant time. Thus it takes O(n) time.
Space complexity: O(1)

We only need to update several parameters a, b, c and tmp, which takes O(1) space.

*/
class Solution {
    public int tribonacci(int n) {
        if(n<3){
            return n > 0 ? 1: 0;
        }

        int a = 0, b = 1, c=1;
        for(int i=3; i<=n;i++){
            int tmp = a+b+c;
            a=b;
            b=c;
            c=tmp;
        }
        return c;
    }
}
