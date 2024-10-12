package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_Graph {
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

    public static boolean graph_coloring(ArrayList<Edge>[] list){
        int col[]=new int[list.length];
        Arrays.fill(col,-1);

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<list.length;i++){
            if(col[i]==-1){   //BFS
                q.add(i);
                col[i]=0;

                while(!q.isEmpty()){
                    int curr=q.remove();
                    for(int j=0;j<list[curr].size();j++){
                        Edge e=list[curr].get(j);
                        // case 1
                        if(col[e.dest]==-1){
                            int nextCol=col[curr]==0?1:0;
                            col[e.dest]=nextCol;
                            q.add(e.dest);
                        }else if(col[e.dest]==col[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
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

        System.out.println(graph_coloring(list));
    }
}

