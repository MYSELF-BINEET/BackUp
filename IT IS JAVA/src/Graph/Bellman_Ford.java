package Graph;

import java.util.ArrayList;

public class Bellman_Ford {
    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static void bellman_ford(ArrayList<Edge> graph,int src,int V){
        int dist[]=new int[V];

        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i< V-1;i++){
//            for(int j=0;j<graph.length;j++) {
                for(int j=0;j<graph.size();j++) {
                    Edge e = graph.get(j);
                    int u = e.src;
                    int v = e.dest;
                    int w = e.wt;

                    if (dist[u]!=Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                    }
//                }
                }
        }

        for(int i=0;i< dist.length;i++){
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph=new ArrayList<>();

//        for(int i=0;i<V;i++){
//            graph[i]=new ArrayList<>();
//        }

        graph.add(new Edge(0,1,2));
        graph.add(new Edge(0,2,4));
        graph.add(new Edge(1,2,-4));
        graph.add(new Edge(2,3,2));
        graph.add(new Edge(3,4,4));
        graph.add(new Edge(4,1,-1));

        bellman_ford(graph,0,V);
    }
}
