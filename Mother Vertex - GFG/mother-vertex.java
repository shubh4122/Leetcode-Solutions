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
    int topoSortStackTop = -1;
    public int findMotherVertex(int v, ArrayList<ArrayList<Integer>>adj) {
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (! vis[i]) {
                topoSort(adj, vis, i);//doing topological sort.
            }
        }

        vis = new boolean[v];//reinitialise vis array.
        topoSort(adj, vis, topoSortStackTop);//check 1st elem of topological sort visits all nodes

        for (boolean visited : vis) {//if vis array is completely TRUE, i.e. all nodes visited. return ans
            if (!visited)
                return -1;
        }
        return topoSortStackTop;
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
}