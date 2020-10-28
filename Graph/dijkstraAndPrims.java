
import java.util.*;

public class dijkstraAndPrims{

    public static void primsAlgo(ArrayList<Integer>[] graph, int N){
      
        ArrayList<Integer>[] ngraph = new ArrayList[N];

        for (int i = 0; i < N; i++){
            ngraph[i] = new ArrayList<>();
        }
        
        boolean[] visited = new boolean[N];
     
        PriorityQueue<PrimsPair> queue = new PriorityQueue<>((a,b) -> a.w - b.w);
        
        queue.add(new PrimsPair(0, -1, 0));

        int EdgesCount = 0;

        while (EdgesCount < N){
            PrimsPair pair = queue.poll();

            if (visited[pair.vtx])
            continue;

            if (pair.par != -1){
                addEdge(ngraph, pair.vtx, pair.par, pair.w);
                EdgesCount++;
            }

            visited[pair.vtx] = true;

            for (Edge e : graph[pair.vtx]){
                if (!visited[e.v]){
                    queue.add(new PrimsPair(e.v, pair.vtx, e.w));
                }
            }
        }

        display(ngraph,N );
    }

    public static void primsAlgo2(ArrayList<Integer>[] graph, int N){
      
        ArrayList<Integer>[] ngraph = new ArrayList[N];

        for (int i = 0; i < N; i++){
            ngraph[i] = new ArrayList<>();
        }
        
        boolean[] visited = new boolean[N];
        int[] dis = new int[N];
        Arrays.fill(dis, (int) 1e8);
        dis[0] = 0;
     
        PriorityQueue<PrimsPair> queue = new PriorityQueue<>((a,b) -> a.w - b.w);
        
        queue.add(new PrimsPair(0, -1, 0));

        int EdgesCount = 0;

        while (EdgesCount < N){
            PrimsPair pair = queue.poll();

            if (visited[pair.vtx])
            continue;

            if (pair.par != -1){
                addEdge(ngraph, pair.vtx, pair.par, pair.w);
                EdgesCount++;
            }

            visited[pair.vtx] = true;

            for (Edge e : graph[pair.vtx]){
                if (!visited[e.v] && e.w < dis[e.v]){
                    dis[e.v] = e.w;
                    queue.add(new PrimsPair(e.v, pair.vtx, e.w));
                }
            }
        }

        display(ngraph, N);
    }
    private void display(){

    }
    class PrimsPair{
        int par;
        int vtx;
        int w;

        PrimsPair(int vtx, int par, int w){
            this.vtx = vtx;
            this.par = par;
            this.w = w;
        }
    }

}