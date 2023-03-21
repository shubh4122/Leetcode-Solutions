//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int n, int m, int edges[][]){
	    // Code Here. 
	    ArrayList<ArrayList<Pair>> graph = edgeToListWeighted(edges, n, m);
        int mstWt = 0;
        PriorityQueue<Pair> q = new PriorityQueue<>(new Pair());//comparator
        boolean[] vis = new boolean[n];

        q.add(new Pair(0, 0));//any random node pushed
        // vis[0] = true;

        while (!q.isEmpty()) {
            Pair pop = q.remove();
            int node = pop.first;
            int wt = pop.second;
            
            if (vis[node])  continue;

            //taking the shortest edge
            mstWt += wt;
            vis[node] = true;

            for (Pair adj : graph.get(node)) {
                if (!vis[adj.first]) {
                    q.add(adj);
                }
            }
        }
        return mstWt;
	}
	
	
    public static ArrayList<ArrayList<Pair>> edgeToListWeighted(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {//<=n because 1 based indexing
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        return graph;
    }
    
     public static class Pair implements Comparator<Pair> {
        int first, second;
        public Pair(){}

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public int compare(Pair p1, Pair p2) {
            return p1.second - p2.second;//ascending order
        }
    }
}