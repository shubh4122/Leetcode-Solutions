//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> graph) {
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i])
//              NOTE: we return and terminate function only when cycle found.
//              We should not return when its false. Coz it will terminate the funciton
//              and wont check any further. Hence RETURN ONLY WHEN TRUE!!!
                if(dfsCycleDetection(graph, vis, i, -1))
                    return true;
        }
        return false;
    }
        private static boolean dfsCycleDetection(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int node, int parent) {
//        mark node as visited
        vis[node] = true;

//        Check for cycle
/*          Cases:
                1. node n NOT VISITED
                    - call cycleCheck for this n and if cycle found return true.

                2. node n VISITED earlier
                    i. if n == parent, not cycle, hence return false
                    ii. if n != parent, cycle there. return true
 */
        for (int n : graph.get(node)) {
            if (!vis[n]) {
                if (dfsCycleDetection(graph, vis, n, node))
                    return true;
            }
//          it comes here, when n has already been visited earlier
            else if (n != parent)
                return true;
//          DONT return any thing when n==PARENT. Coz it will terminate the call
//          Just continue checking when this condition strikes.
        }
        return false;
    }

}