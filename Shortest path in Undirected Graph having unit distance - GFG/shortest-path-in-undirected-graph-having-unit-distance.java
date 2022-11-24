//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == edges[i][1]) {
                graph.get(edges[i][0]).add(edges[i][1]);
                continue;
            }
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] dist = new int[n];
        shortestDist_Undirected_UnitWt(graph, n, dist, src);
        return dist;
    }
    
    public void shortestDist_Undirected_UnitWt(ArrayList<ArrayList<Integer>> graph, int n, int[] dist, int src) {

//      No vis arr required, As multiple visits can be done to a node, and then we see whose dist is min!!
        Queue<Integer> q = new ArrayDeque<>();
//      Replace each val with (infinity) and then replace it if a dist lower than that occurs.
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.add(src);
        dist[src] = 0;

        while(!q.isEmpty()) {
            int parent = q.remove();

            for (int adjNode : graph.get(parent)) {
//              Check if the dist to adjNode from src is less than its stored Dist, then replace. Else ignore
//              dist[parent] is dist of parent from src
                int newDist = dist[parent] + 1;
                if (newDist <= dist[adjNode]){
                    dist[adjNode] = newDist;
//                  only that adjNode must enter queue, whose new dist < its current dist
                    q.add(adjNode);
                }
//              else ignore newDist.
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
    }
        
}