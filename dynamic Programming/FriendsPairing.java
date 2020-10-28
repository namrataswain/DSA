public class FriendsPairing {
   public static void main(String[] args) {
       int n = 4;
        
       System.out.println("Q2. Friends Pairing Problem");
 
       
       System.out.println("Using normal recusrion answer is : ");
       System.out.println("For" + n + " total ways are " +totalWaysToPair(n));
       

       System.out.println("Using memoization answer is : ");
       System.out.println("For" + n + " total ways are " + findTotalWays(n));

       System.out.println("Using Tabulation answer is : ");
       System.out.println("For" + n + " total ways are " + totalWaysToPairTabu(n));
   } 

   public static int findTotalWays(int n){
       int[] dp= new int[n+1];

       totalWaysToPairMemo(n,dp);

       return dp[n];
   }

   //normal recusrion
   public static int totalWaysToPair(int n){
       if (n <= 1)
       return 1;


       int ways = 0;

    ways += totalWaysToPair(n-1);
    ways += totalWaysToPair(n-2) * (n-1);
    return ways;
   }

   //memoization
   public static int totalWaysToPairMemo(int n, int[] dp){
       if (n <= 1)
       return dp[n] = 1;


       if (dp[n] != 0)
       return dp[n];

       dp[n] = totalWaysToPairMemo(n-1, dp) + (n-1) * totalWaysToPairMemo(n-2, dp);

       return dp[n];
   }

   //tabulation
   public static int totalWaysToPairTabu(int n){
       int[] dp = new int[n+1];
       dp[0] = 1;
       dp[1] = 1; 
       for (int i = 2; i < n+1; i++){
          dp[i] = dp[i-1] + dp[i-2]*(i-1);
       }

       return dp[n];
   }
}
