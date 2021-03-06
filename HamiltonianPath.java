import java.util.*;
class HamiltonianPath{
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
        addEdge(5,2, 1);


        System.out.println(hamiltonianPath(0,0, new boolean[N],0, ""));

    }

    public static void main(String[] args){
        constructGraph();
    }
     
    public static int searchVtx(int u,int v){
        for(int i=0;i<graph[u].size();i++){
            Edge e = graph[u].get(i);
            if(e.v == v) return i;
        }

        return -1;
    }
   
    public static int hamiltonianPath(int src, int osrc, boolean[] visited, int edgeCount, String psf){
     
       if (edgeCount == N-1){
           psf += src;
          
           int idx = searchVtx(src, osrc);

           if (idx != -1){
               System.out.println("Cycle " +" "+ psf);
           }
           else{
               System.out.println("Path" +" "+ psf);
           }

           return 1;
       }


       visited[src] = true;
       
       int count = 0;
       for (Edge e : graph[src]){
           if (!visited[e.v]){
               count += hamiltonianPath(e.v, osrc, visited, edgeCount+1, psf + src+" -> ");
           }
       }
       
       visited[src] = false;
        return count;
    }

}