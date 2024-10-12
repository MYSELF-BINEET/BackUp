package Graph;

import java.util.ArrayList;

public class Cycle_Detec_Directed {
    static class Edge{
        int src;
        int dest;

        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }

    public static boolean hasCycleUtil(ArrayList<Edge>[] graph,boolean[] stack,boolean[] visited,int curr){
        visited[curr]=true;
        stack[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(stack[e.dest]){
                return true;
            }else if(!visited[e.dest] && hasCycleUtil(graph,stack,visited,e.dest)){
                return true;
            }
        }

        stack[curr]=false;
        return false;
    }

    public static boolean hasCycle(ArrayList<Edge>[] graph){
        boolean [] stack=new boolean[graph.length];
        boolean [] visited=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]) {
                if (hasCycleUtil(graph, stack, visited, i)) {
                    return true;
                }
            }
//            return hasCycleUtil(graph,stack,visited,i);
        }
        return false;
    }

    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge>[] graph=new ArrayList[V];

        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }

        graph[1].add(new Edge(1,0));
        graph[0].add(new Edge(0,2));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));

        System.out.println(hasCycle(graph));
//        for(int i=0;i<graph[0].size();i++){
//            Edge e=graph[0].get(i);
//            System.out.println(e.src);
//            System.out.println(e.dest);
//        }
    }
}
