/*463. Island Perimeter - Easy 

You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

https://leetcode.com/problems/island-perimeter/description/
*/

/* Time compleixty - Time complexity : O(mn) where mmm is the number of rows of the grid and nnn is
the number of columns of the grid. Since two for loops go through all
the cells on the grid, for a two-dimensional grid of size m×n, the algorithm
would have to check mnmnmn cells.


Space complexity : O(1). Only the result variable is updated and there is
no other space requirement.
*/
class Solution {
    final int PERIMETER = 4;
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0]. length;

        int up, down, left, right;
        int result = 0;
        for(int r = 0; r<row;r++){
            for(int c = 0; c<col;c++){
                if(grid[r][c] == 1){
                    if(r == 0) up = 0;
                    else { up = grid[r-1][c]; }

                    if(c == 0) left = 0;
                    else { left = grid[r][c-1]; }

                    if(r == row-1) down = 0;
                    else { down = grid[r+1][c]; }

                    if(c == col-1) right = 0;
                    else { right = grid[r][c+1];}

                    result += PERIMETER - (up +left +down+right);
                }
                
            }
        }
        return result;
    }
}
