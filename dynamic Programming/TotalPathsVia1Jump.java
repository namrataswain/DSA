public class TotalPathsVia1Jump {
    public static void main(String[] args) {
        
        // System.out.println("Answer using normal recusrive solution");
        // System.out.println(totalPaths(4));

        System.out.println("Answer using memoization solution");
        System.out.println(totalPaths(3));

        // System.out.println("Answer using tabulation solution");
        // System.out.println(totalPaths(4));
    }

    public static int totalPathsRecursive(int N, int x, int y, int[][] dp){
        
        if (x >= N || y >= N)
        return 0;

        if (x == N-1 && y == N-1)
        return dp[x][y] = 1;

        int a = totalPathsRecursive(N, x+1, y, dp);
        int b = totalPathsRecursive(N, x, y+1, dp);
        int c = totalPathsRecursive(N, x+1, y+1, dp);

        return dp[x][y] = a + b+ c;
    }

    public static int totalPathsMemo(int N, int x, int y, int[][] dp){
        if (x >= N || y >= N)
        return 0;

        if (x == N-1 && y == N-1)
        return dp[x][y] = 1;

        if (dp[x][y] != 0)
        return dp[x][y];

        int a = totalPathsRecursive(N, x+1, y, dp);
        int b = totalPathsRecursive(N, x, y+1, dp);
        int c = totalPathsRecursive(N, x+1, y+1, dp);

        return dp[x][y] = a + b+ c;
    }

    // public static int totalPathsTabulation(int N, int x, int y, int[][] dp){
    //     return 
    // }

    public static int totalPaths(int N){
        int[][] dp = new int[N][N];

        //return totalPathsRecursive(N, 0, 0, dp);
        int count = totalPathsMemo(N, 0, 0, dp);
        //return totalPathsTabulation(N, 0, 0, dp);
        print2D(dp);
        return count;
    }

    private static void print1D(int[] arr){
        for(int n : arr)
        System.out.print(n+" ");
    }

    private static void print2D(int[][] arr){
        for (int[] a : arr){
            print1D(a);
            System.out.println();
        }
    }
}
