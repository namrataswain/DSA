import java.util.*;


public class topological {
    
    static int N = 14;
    static ArrayList<Integer>[] graph = new ArrayList[N];
     
    public static void constructGraph(){
        for(int i = 0;i<N;i++) 
        graph[i] = new ArrayList<Integer>();


        graph[0].add(10);
        graph[1].add(8);
        graph[1].add(8);
        graph[1].add(8);
        graph[1].add(8); 
        graph[1].add(8); 
        graph[1].add(8);
        graph[1].add(8);
        graph[1].add(8);
        graph[1].add(8);
        graph[1].add(8);
        graph[1].add(8);
        graph[1].add(8);
        graph[1].add(8);
        graph[1].add(8);
        graph[1].add(8);

        
    }

    //using DFS topological ordering
    public static void TopoDFS(int src, boolean[] visited, ArrayList<Integer> ans){
      visited[src] = true;

      for (int nei : graph[src]){
          if (!visited[nei]){
              TopoDFS(nei, visited, ans);
          }
      }
      ans.add(src);
    }
    

    public static void TopoDFS(){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[N];

        for (int i = 0; i < N; i++){
            if (!visited[i]){
                TopoDFS(i, visited, ans);
            }
        }
    }


    //using bfs

    
}
