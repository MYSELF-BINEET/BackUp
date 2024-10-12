package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Topological_Sort_BFS {
    static class Edge{
        int src;
        int dest;

        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }

    public static void countInDegree(ArrayList<Edge>[] graph,int[] inDeg){
        for(int i=0;i<graph.length;i++){
            int v=i;
            for(int j=0;j<graph[v].size();i++){
                Edge e=graph[v].get(j);
                inDeg[e.dest]++;
            }
        }
    }

    public static void sort(ArrayList<Edge>[] graph){
        int inDeg[]=new int[graph.length];

        countInDegree(graph,inDeg);

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<inDeg.length;i++){
            if(inDeg[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr= q.remove();
            System.out.print(curr+"->");
            for(int i=0;i<graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                inDeg[e.dest]--;
                if(inDeg[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>[] graph=new ArrayList[V];

        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }

        graph[2].add(new Edge(2,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,3));
        graph[3].add(new Edge(3,2));

        sort(graph);
    }
}
