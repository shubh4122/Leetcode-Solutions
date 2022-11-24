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
        
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
//      If a node isn't reachable from src, its dist from it be -1
        Arrays.fill(dist, -1);
        
//      Add src to Q, mark it vis, and its dist from itself as 0
        q.add(src);
        vis[src] = true;
        dist[src] = 0;
        
        while(!q.isEmpty()) {
            int parent = q.remove();
            for (int adjNode : graph.get(parent)) {
                if (!vis[adjNode]) {
//                  Put it in Q, mark it vis, and write its dist
                    q.add(adjNode);
                    vis[adjNode] = true;
                    dist[adjNode] = dist[parent] + 1;
                }
            }
        }
    }
        
}