/*
452. Minimum Number of Arrows to Burst Balloons

There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array points, return the minimum number of arrows that must be shot to burst all balloons.

https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description

*/


class Solution {
    /*Time Complexity - O(Nlogn) Space Complaexity = O(N) or O(logN) due to sorting */
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;

        Arrays.sort(points, (p1,p2)-> {
            if(p1[1] == p2[1]) return 0;
            if(p1[1] < p2[1]) return -1;
            return 1;

        });
        int arrowCnt = 1, arrowEnd = points[0][1], cStart;
        for(int[] p: points){
            cStart = p[0];

            if(arrowEnd < cStart){
                arrowCnt++;
                arrowEnd = p[1];
            }
        }
        return arrowCnt;
    }
}
