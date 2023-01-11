//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> graph)
    {
        //code here
        /*
         ----------------------------------------------
        |                Kosaraju Algo                 |
        |     1. Sort the edges acc to finishing time  |
        |     2. Reverse Graph(All edges of graph)     |
        |     3. Do DFS in the SORTED order            |
         ----------------------------------------------
 */
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i])
                dfsKosaraju1(graph, vis, i, st);
        }
        //At this point, we have stack with sorted values.

        //Reversing graph
        Arrays.fill(vis, false);
        ArrayList<ArrayList<Integer>> graphReversed = new ArrayList<>();//new graph
        for (int i = 0; i < V; i++) {
            graphReversed.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < V; i++) {
            if (!vis[i])
                dfsKosaraju2(graph, vis, i, graphReversed);
        }
        //At this point we have reversed graph in graphRev

        //Do DFS to find SCC
        Arrays.fill(vis, false);
        int countSCC = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (!vis[node]) {
                countSCC++;
                dfsKosaraju3(graphReversed, vis, node);
            }
        }

        return countSCC;
    }
    
    
    //For DFS finally to count SCC
    private static void dfsKosaraju3(ArrayList<ArrayList<Integer>> graphReversed, boolean[] vis, int node) {
        if (vis[node])
            return;

        vis[node] = true;

        for (int val : graphReversed.get(node)) {
            dfsKosaraju3(graphReversed, vis, val);
        }
    }

    //To REVERSE the graph
    private static void dfsKosaraju2(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int temp, ArrayList<ArrayList<Integer>> graphReversed) {
        if (vis[temp])
            return;

        vis[temp] = true;

        for (int val : graph.get(temp)) {
            graphReversed.get(val).add(temp);
            dfsKosaraju2(graph, vis, val, graphReversed);
        }
    }
    
    //To SORT the vertices in order of FINISHING TIME
    private static void dfsKosaraju1(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int temp, Stack<Integer> st) {
        if (vis[temp])
            return;

        vis[temp] = true;

        for (int val : graph.get(temp)) {
            dfsKosaraju1(graph, vis, val, st);
        }
        //This adds the Nodes in stack. 1st finished node enters first. and hence last finished is on TOP
        st.add(temp);
    }

}
