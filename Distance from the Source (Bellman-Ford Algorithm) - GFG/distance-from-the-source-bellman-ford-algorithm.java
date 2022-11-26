//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                t1.add(u);
                t1.add(v);
                t1.add(w);
                edges.add(t1);
            }

            int S = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            int[] ptr = ob.bellman_ford(V, edges, S);

            for (i = 0; i < ptr.length; i++) System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
*   edges: vector of vectors which represents the graph
*   S: source vertex to start traversing graph with
*   V: number of vertices
*/
class Solution {
    static int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> edges, int src) {
        // Write your code here
        int[] dist = new int[n];
        Arrays.fill(dist, 100000000);
        dist[src] = 0;

/*
        |----------------------------------------------|
        |               Relax n-1 times                |
        |----------------------------------------------|
*/

        for (int i = 0; i < n - 1; i++) {
            relax(edges, dist, false);
        }

        //This is nth call to relax. If now it enters the below IF in Relax. where dist changes. It will tell me, it changed.
        boolean isNegCycle = relax(edges, dist, true);
        if (isNegCycle)
            return new int[]{-1};
        
        return dist;
    }
    
    
    private static boolean relax(ArrayList<ArrayList<Integer>> edges, int[] dist, boolean isNthCall) {
        //edge ->  (u, v, w).  u: parent. v : adjNode. w : weight
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            int newDist = dist[u] + w;
            if (dist[u] != 100000000 && newDist < dist[v]) { // for nodes which havent been reached yet. we wont relax them.
                dist[v] = newDist;
                //this is solely done for the nth iteration, finding presence of negative cycle.
                if (isNthCall)
                    return true;// true coz, this is Nth call, and it entered here which means DIST[] is changed.
            }
        }
        return false;//no negative cycle
    }
}
