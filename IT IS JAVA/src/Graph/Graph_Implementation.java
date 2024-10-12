package Graph;

import java.util.ArrayList;

public class Graph_Implementation {
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

        for(int i=0;i<list[3].size();i++){
            Edge e=list[3].get(i);
            System.out.println(e.src);
            System.out.println(e.dest);
            System.out.println(e.wt);
        }
    }
}
