//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> graph) {
        // code here
        boolean visited[] = new boolean[n];
        boolean dfsVisited[] = new boolean[n];

        for (int node = 0; node < n; node++) {
            if (!visited[node])
                if (checkCycleDFS(graph, node, visited, dfsVisited))
                    return true;
        }
        return false;
    }
    
    public static boolean checkCycleDFS(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited, boolean[] dfsVisited) {
//      No Base Condtion here !! IMP HERE
//      Whenever any node is visited. mark both arrays as visited!
        visited[node] = true;
        dfsVisited[node] = true;

//       Now Check each node's Adj nodes, to have both vis = dfsVis = true
        for (int adjNode : graph.get(node)) {
            if (!visited[adjNode]) {
                if (checkCycleDFS(graph, adjNode, visited, dfsVisited))
                    return true;
            }
//          This condition means, vis[adj] = true, and dfsvis[adj] is also TRUE. HENCE CYCLE FOUND
            else if (dfsVisited[adjNode] == true)
                return true;
        }

//      SEE WHAT IT DOES??
        dfsVisited[node] = false;
        return false;
    }


}