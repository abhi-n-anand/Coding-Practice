/**

Given a 2d grid map of '1's (land) and '0's (water),
 count the number of islands.
  An island is surrounded by water and is formed by
   connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

**/

class Solution {
    public int numIslands(char[][] grid) {
        int answer = 0;
        if (grid == null) return answer;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    answer++;
                    dfs(grid, i, j);
                }
            }
        }
        return answer;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == '0') return;
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
