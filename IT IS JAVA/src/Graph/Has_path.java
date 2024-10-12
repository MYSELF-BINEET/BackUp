package Graph;

import java.util.ArrayList;

public class  Has_path{
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

    public static boolean hasPath(ArrayList<Edge>[] list,int src,int dest,boolean[] visited){
        if(src==dest){
            return true;
        }
        visited[src]=true;
        int size=list[src].size();
        for(int i=0;i<size;i++){
            Edge e=list[src].get(i);
            if(!visited[e.dest] && hasPath(list,e.dest,dest,visited)){
//                visited[e.dest]=true;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge>[] list=new ArrayList[V];

        for(int i=0;i<7;i++){
            list[i]=new ArrayList<>();
        }

        // 0 vertex
        list[0].add(new Edge(0,1,1));
        list[0].add(new Edge(0,2,2));


        // 1 vertex
        list[1].add(new Edge(1,3,3));

        // 2 vertex
        list[2].add(new Edge(2,4,4));

        // 3 vertex
        list[3].add(new Edge(3,4,5));
        list[3].add(new Edge(3,5,7));

        //4 vertex
        list[4].add(new Edge(4,3,6));
        list[4].add(new Edge(4,5,8));

        // 5 vertex
        list[5].add(new Edge(5,6,9));

        boolean[] visited=new boolean[list.length];

        System.out.println(hasPath(list,0,5,visited));
    }
}

