import java.util.*;
public class LongestIncreasingPath {
    
    //using topological sorting
    
    public static int maxLen(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] indegree = new int[n][m];
        int[][] dir ={{0,1},{0,-1},{1,0},{-1,0}};

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                for (int[]d : dir){
                    int nr = d[0] + i;
                    int nc = d[1] + j;

              if (nr >= 0 && nc >= 0 && nr < n && nc < m && matrix[nr][nc] > matrix[i][j]) 
              indegree[nr][nc]++;     
                }
            }
        }
    

   Queue<Integer> queue = new LinkedList<>();

   for (int i = 0; i < n; i++){
       for (int j = 0; j < m; j++){
           if (indegree[i][j] == 0)
           queue.add(i *m + j);
       }
   }

   int level = 0;

   while (!queue.isEmpty()){
       int size = queue.size();

       while (size-- > 0){
        int ver = queue.poll();
        int r = ver/m;
        int c = ver % m;
 
        for (int[] d : dir){
            int nr = d[0] + r;
            int nc = d[1] + c;

            if (nr >= 0 && nc >= 0 && nr < n && nc < m && matrix[nr][nc] > matrix[r][c] && --indegree[nr][nc] == 0){
                queue.add(nr * m + nc);
            }
        }
       }
       level++;
       
   }

     return level;
    }

    public static void main(String[] args) {
        int[][] matrix ={{9,9,4},{6,6,8},{2,1,1}};

        System.out.println(maxLen(matrix));
    }
}
