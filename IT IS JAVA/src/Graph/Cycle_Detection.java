package Graph;

import java.util.ArrayList;

public class  Cycle_Detection{
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

    public static boolean isCycleUtil(ArrayList<Edge>[] list,int curr,boolean vis[],boolean stack[]){
        vis[curr]=true;
        stack[curr]=true;

        for(int i=0;i<list[curr].size();i++){
            Edge e=list[curr].get(i);
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest] && isCycleUtil(list,e.dest,vis,stack)){
                return true;
            }
        }
        return false;
    }


    public static boolean hasCycle(ArrayList<Edge>[] list){
        boolean[] visited=new boolean[list.length];
        boolean[] stack=new boolean[list.length];

        for(int i=0;i< list.length;i++){
            if(!visited[i]){
                if(isCycleUtil(list,i,visited,stack)){
                    return true;
                }
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


//        // 1 vertex
//        list[1].add(new Edge(1,3,3));
//
//        // 2 vertex
//        list[2].add(new Edge(2,4,4));
//z
//        // 3 vertex
//        list[3].add(new Edge(3,4,5));
//        list[3].add(new Edge(3,5,7));
//
//        //4 vertex
//        list[4].add(new Edge(4,3,6));
//        list[4].add(new Edge(4,5,8));
//
//        // 5 vertex
//        list[5].add(new Edge(5,6,9));

        list[0].add(new Edge(0,2,2));
        list[1].add(new Edge(1,0,3));
        list[2].add(new Edge(2,3,4));
        list[3].add(new Edge(3,0,5));

        boolean[] visited=new boolean[list.length];

        System.out.println(hasCycle(list));
    }
}



