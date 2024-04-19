/*
200. Number of Islands - Medium
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
https://leetcode.com/problems/number-of-islands/description/
*/



/*
Time complexity : O(M×N) where M is the number of rows and
N is the number of columns.

Space complexity : worst case O(M×N) in case that the grid map
is filled with lands where DFS goes by M×N deep.

*/

class Solution {    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int numOfIsLands = 0;
        for(int r= 0; r<grid.length;r++){
            for(int c=0; c<grid[r].length; c++){
                if(grid[r][c] == '1') {
                    numOfIsLands++;
                    dfs(grid, r, c);
                }
            }
        }
       return numOfIsLands;
    }

    private void dfs(char[][] grid, int row, int col){

        if(row<0 || col<0 || row>=grid.length 
        || col>=grid[row].length || grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);

    }
}
