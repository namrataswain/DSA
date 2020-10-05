import java.util.ArrayList;


public class Graph{

    public static class Edge{
        int v = 0;
        int w = 0;

        public Edge(int v,int w){
            this.v = v;
            this.w = w;
        }
    }

    static int N = 7;
    
    static ArrayList<Edge>[] graph = new ArrayList[N];

    public static void addEdge(int u,int v,int w){
        graph[u].add(new Edge(v,w));
        graph[v].add(new Edge(u,w));
    }

    public static void display(){
        for(int i=0;i<N;i++){
            System.out.print(i + " -> ");
            for(Edge e: graph[i]){
                System.out.print("(" + e.v + ", " + e.w + "), ");
            }

            System.out.println();
        }
    }

    public static int searchVtx(int u,int v){
        for(int i=0;i<graph[u].size();i++){
            Edge e = graph[u].get(i);
            if(e.v == v) return i;
        }

        return -1;
    }

    public static void removeEdge(int u,int v){
        int l1 = searchVtx(u,v);
        graph[u].remove(l1);

        int l2 = searchVtx(v,u);
        graph[v].remove(l2);
    }

    public static void removeVtx(int u){
        for(int i = graph[u].size()-1;i>=0;i--){
            Edge e = graph[u].get(i);
            removeEdge(u,e.v);
        }
    }

    public static boolean hasPath(int src,int dest){
       boolean[] visited = new boolean[N];

       return dfs(src, dest, visited, graph);
    }
    
    private static  boolean dfs(int src, int dest, boolean[] visited, ArrayList<Edge>[] graph){
        if (src == dest){
            return true;
        }

        visited[src] = true;
        
        for (Edge e : graph[src]){
            if (!visited[e.v]){
                boolean res = dfs(e.v, dest, visited, graph);
                if (res)
                return true;
            }
        }
       return false;
    }

    public static int allPath(int src,int dest){
        boolean[] visited = new boolean[N];
        int count = countPaths(src, dest, visited, graph,src+"");
         return count;
    }

    private  static int countPaths(int src, int dest, boolean[] visited, ArrayList<Edge>[] graph, String psf){
        if (src == dest){
           
            System.out.println(psf);
            return 1;
        }

        visited[src] = true;
         int count = 0;
        for (Edge e : graph[src]){
            if(!visited[e.v]){
               count += countPaths(e.v, dest, visited, graph, psf + " -> "+ e.v);
            }
        }
        visited[src] = false;
        return count;
    }
     static int  maxweight = Integer.MIN_VALUE;
     static String path = "";
    public static void maxWeight(int src, int dest, boolean[] visited, ArrayList<Edge>[] graph, String psf, int wsf){
        if (src == dest){
          if (wsf > maxweight){
            maxweight = wsf;
            path = psf + dest;
          }
          return;
        }

        visited[src] = true;

        for (Edge e : graph[src]){
            if (!visited[e.v]){
                maxWeight(e.v, dest, visited, graph, psf + src+" -> ", wsf + e.w);
            }
        }
       
        visited[src] = false;

    }
     
    static int  minweight = Integer.MAX_VALUE;
     static String minpath = "";
    public static void minWeight(int src, int dest, boolean[] visited, ArrayList<Edge>[] graph, String psf, int wsf){
        if (src == dest){
          if (wsf < minweight){
            minweight = wsf;
            minpath = psf + dest;
          }
          return;
        }

        visited[src] = true;

        for (Edge e : graph[src]){
            if (!visited[e.v]){
                minWeight(e.v, dest, visited, graph, psf + src +" -> ", wsf + e.w);
            }
        }
       
        visited[src] = false;

    }
   
    public static class Pair{
        String path;
        int weight;

        Pair(String path, int weight){
          this.path = path;
          this.weight = weight;
        }
    }


    public static Pair maxWeightPath(int src, int dest, boolean[] vis){
       
        if (src == dest){
            return new Pair("",0);
        }

      vis[src] = true;  
      Pair myAns = new Pair("",0);
       
      for (Edge e : graph[src]){
         if (!vis[e.v]){
             Pair recAns = maxWeightPath(e.v, dest, vis);

             if (recAns.weight + e.w  > myAns.weight){
                 myAns.weight = recAns.weight + e.w;
                 myAns.path = src +" "+  recAns.path;
             }
         }
      }

      vis[src] = false;

      return myAns;
      
    }

    


    public static void constructGraph(){
        for(int i = 0;i<N;i++) graph[i] = new ArrayList<Edge>();

        addEdge(0,1,10);
        addEdge(0,3,10);
        addEdge(1,2,10);
        addEdge(2,3,40);
        addEdge(3,4,2);
        addEdge(4,5,2);
        addEdge(4,6,8);
        addEdge(5,6,3);

        // removeVtx(3);
        // boolean res = hasPath(0, 7);
        // System.out.print(res);
        //display();

        // int count = allPath(0, 6);
        // System.out.print(count);
       boolean[] visited = new boolean[N];
        // maxWeight(0, 6, visited, graph, "", 0);

        // System.out.println(path+ " @ " + maxweight);


        // minWeight(0, 6, visited, graph, "", 0);

        // System.out.println(minpath+ " @ " + minweight);

        Pair ans = maxWeightPath(0, 6, visited);

        System.out.println(ans.path+" @ " + ans.weight);


    }

    public static void main(String[] args){
        constructGraph();
    }



}