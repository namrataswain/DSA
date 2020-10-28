class Islands{
    static int[] dir ={0,1,0,-1,0};
    public static void main(String[] args) {
    char[][] grid = {
    {'1','1','1','1','0'},
  {'1','1','0','1','0'},
  {'1','1','0','0','0'},
  {'0','0','0','0','0'}
    };
   
    

   System.out.println(numIslands(grid));

    }
    
    public static int numIslands(char[][] grid){
       int count = 0;   
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    count++;
                    numIslandsDfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public  static void numIslandsDfs(char[][] grid, int r, int c){
      
        grid[r][c] = '0';

        for (int d = 0; d < dir.length - 1; d++){
            int nr = dir[d] + r;
            int nc = dir[d+1] + c;
           
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1'){
                numIslandsDfs(grid, nr, nc);
            }
            
        }
    }
}