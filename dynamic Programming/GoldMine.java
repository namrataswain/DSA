 
 public class GoldMine{
   static  int[][] dir ={{0,1},{-1,1},{1,1}};
    public static void main(String[] args) {
        int[][] matrix = {{10, 33, 13, 15},
        {22, 21, 04, 1},
        {5, 0, 2, 3},
        {0, 6, 14, 2}};

        //System.out.println(maxGoldCollected(matrix));
        System.out.println("Answer using Memoization ");
        System.out.println(maxGoldCollectedMemo(matrix));

        System.out.println("Answer using Tabulation");
        System.out.println(maxGoldCollectedTabu(matrix));

    }

    public static int maxGoldCollected(int[][] mine){
        
        int max = 0;

        for(int i = 0; i < mine.length; i++){
            max = Math.max(max, mine[i][0] + findMax(mine, i, 0));
        }

        return max;
    }

    private static int findMax(int[][] mine, int r, int c){
        if (r >= mine.length || r < 0 || c >= mine[0].length|| c < 0)
            return 0;

        int collect = 0;

        for (int[] d : dir){
            int nr = d[0] + r;
            int nc = d[1] + c;
            
            if (nr >= 0  && nc >= 0 && nr < mine.length && nc < mine[0].length){
                collect = Math.max(collect, mine[nr][nc] + findMax(mine, nr, nc));
            }
            
        }
     return collect;
    }
     
    public static int maxGoldCollectedMemo(int[][] mine){
        
        int m = mine.length;
        int n = mine[0].length;

        int[][] dp = new int[m][n];

        int max = 0;
         
        for(int i = 0; i < mine.length; i++){
            max = Math.max(max, mine[i][0] + findMaxMemo(mine, i, 0, dp));
        }

        return max;
    }

    private static int findMaxMemo(int[][] mine, int r, int c, int[][] dp){
        if (c == mine[0].length -1)
        return dp[r][c] = mine[r][c];

        if (dp[r][c] != 0)
        return dp[r][c];

        int collect = 0;

        for (int[] d : dir){
            int nr = d[0] + r;
            int nc = d[1] + c;
            
            if (nr >= 0  && nc >= 0 && nr < mine.length && nc < mine[0].length){
                collect = Math.max(collect, mine[nr][nc] + findMaxMemo(mine, nr, nc, dp));
            }
            
        }
     return dp[r][c] = collect;
    }

    public static int maxGoldCollectedTabu(int[][] mine){
        int m = mine.length;
        int n = mine[0].length;
        int[][] dp = new int[m][n];

        for (int r = m-1; r >= 0; r--){
            for (int c = n-1; c >= 0; c--){
                if (c == n-1){
                    dp[r][c] = mine[r][c];
                    continue;
                }

                int collect = 0;
                for (int[] d : dir){
                    int nr = d[0] + r;
                    int nc = d[1] + c;
                    
                    if (nr >= 0  && nc >= 0 && nr < mine.length && nc < mine[0].length){
                        collect = Math.max(collect, mine[nr][nc] + dp[nr][nc]);
                    }
                    
                }
             dp[r][c] = collect;
            }
        }
        
        int max = 0;
        for (int r = 0; r < m ; r++){
              max = Math.max(max, dp[r][0]);
        }

        return max;
    }

}