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
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000);
        dist[S] = 0;

        for (int i = 0; i < V - 1; i++) {
            //relax v-1 times over all edges
            for (int j = 0; j < edges.size(); j++) {
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int wt = edges.get(j).get(2);

                relax(dist, u, v, wt, false);
            }
        }

        //if there had been no -ve cycle the dist[] will remain unchanged in nTH iteration.
        //if dist[] changes it means there is -ve cycle

        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);
            int wt = edges.get(i).get(2);

            if (relax(dist, u, v, wt, true))//cycle found
                return new int[]{-1};
        }
        
        return dist;
    }
    
    public static boolean relax(int[] dist, int u, int v, int wt, boolean isNthCall) {
        if (dist[u] != 100000000) {
            int newDist = dist[u] + wt;
            if (newDist < dist[v]) {
                dist[v] = newDist;
                if (isNthCall)
                    return true;
            }
        }
        return false;
    }
}
