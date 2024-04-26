/*1289. Minimum Falling Path Sum II - Hard
Given an n x n integer matrix grid, return the minimum sum of a falling path with non-zero shifts.

A falling path with non-zero shifts is a choice of exactly one element from each row of grid such that no two elements chosen in adjacent rows are in the same column.
*/

//Time Complexity - O(N3) , Space complexity - O(N2)
class Solution {
    Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
    public int minFallingPathSum(int[][] grid) {
        
        int result = Integer.MAX_VALUE;
        for(int col = 0; col<grid[0].length; col++){
            result = Math.min(result, minFallingPathSumUtil(0, col, grid));
        }
        return result;
    }

    private int minFallingPathSumUtil(int row, int col, int[][] grid) {
        
        if(row == grid.length-1){
            return grid[row][col];
        }
        if(memo.containsKey(new Pair(row, col))){
            return memo.get(new Pair(row, col));
        }
        int result = Integer.MAX_VALUE;
        for(int newCol = 0; newCol<grid[row].length; newCol++){
            if(newCol != col){
                result = Math.min(result, minFallingPathSumUtil(row+1, newCol, grid));
            }
        }

        memo.put(new Pair(row,col), grid[row][col] + result);
        return memo.get(new Pair(row, col));
    }
}
