package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Topological_Sort {
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }

    public static void sortUtil(ArrayList<Edge>[] graph,Stack s,boolean[] visited,int curr){
        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(!visited[curr]){
                sortUtil(graph,s,visited,e.dest);
            }
        }
        s.push(curr);
    }

    public static void sort(ArrayList<Edge>[] graph){
        boolean[] visited=new boolean[graph.length];
        Stack s=new Stack();

        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                sortUtil(graph,s,visited,i);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop()+"->");
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge>[] graph=new ArrayList[V];

        for(int i=0;i<graph.length;i++){
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
