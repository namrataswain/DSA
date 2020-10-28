import java.util.*;
public class SCC {

    static int N = 11;
    public static void DFS_SSC(int src, boolean[]vis, ArrayList<Integer> path){
        vis[src] = true;

        for (int nei : graph[src]){
            if (!vis[nei]){
                DFS_SSC(nei, vis, path);
            }
        }
        path.add(src);
    }

    public static void SCC(){

        //step : 1 topological order
        ArrayList<Integer> path = new ArrayList<>();
        boolean[]  vis = new boolean[N];

        for (int i = 0; i < N; i++){
            if (!vis[i])
            DFS_SSC(i, vis, path);
        }
        //step : 2 reverse the graph 
       ArrayList<Integer>[] ngraph = new ArrayList<>();
       for (int i = 0; i < N i++){
           ngraph[i] = new ArrayList<>();
       }

       for (int i = 0; i < N; i++){
           for (int nei : graph[i]){
               ngraph[nei].add(i);
           }
       }

       //dfs over topoplogical order
       vis = new boolean[N];

       for (int i = path.size()-1; i >= 0; i--){
           if (!vis[i]){
               count++;
               DFS_SSC2(i, ngraph, path);
           }
       }

    }
    
}
