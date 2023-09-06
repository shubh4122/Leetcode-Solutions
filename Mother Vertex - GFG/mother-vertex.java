//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
            }
            Solution obj = new Solution();
            int ans = obj.findMotherVertex(V, adj);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends



class Solution
{
    int count = 0;
    int topoSortStackTop = -1;
    public int findMotherVertex(int v, ArrayList<ArrayList<Integer>>adj) {
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (! vis[i]) {
                count = 1;
                topoSort(adj, vis, i);
            }
        }
        // System.out.println(topoSortStackTop);
        vis = new boolean[v];
        visitAllNodes(adj, vis, topoSortStackTop);
        // System.out.println(count);
        if (count == v)
            return topoSortStackTop;
        
        return -1;
    }

    private void topoSort(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int src) {
        if (vis[src])
            return;
        
        vis[src] = true;
        for (int adj : graph.get(src)) {
            topoSort(graph, vis, adj);
        }
        topoSortStackTop = src;
    }

    private void visitAllNodes(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int src) {
        if (src == -1)
            return;
        
        if (! vis[src]) {
            vis[src] = true;
            for (int adjNode : graph.get(src)) {
                if (!vis[adjNode]) {
                    count++;
                    visitAllNodes(graph, vis, adjNode);
                }
            }
        }
    }
}