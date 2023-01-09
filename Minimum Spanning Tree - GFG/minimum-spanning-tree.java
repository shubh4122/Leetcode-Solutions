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
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    PriorityQueue<Pair> pq = new PriorityQueue<>(new Pair()); // new Pair() is comparator given to pq to use.
        boolean[] vis = new boolean[V];
        int mstSum = 0;
        ArrayList<ArrayList<Pair>> graph = edgesToListWeightedUndirected(edges, V);

        //put any random node in PQ, as starting point
        pq.add(new Pair(0, 0)); // pair(src, wt)

        while (!pq.isEmpty()) {
            Pair topNode = pq.remove();
            int node = topNode.node;
            int wt = topNode.weight;

            if (vis[node])  continue;
            vis[node] = true;
            mstSum += wt;

            for (Pair adjNode : graph.get(node)) {
                if (!vis[adjNode.node]) {
                    pq.add(adjNode);
                }
            }
        }
        return mstSum;
	}
	
	
    public static ArrayList<ArrayList<Pair>> edgesToListWeightedUndirected(int[][] edges, int n) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < edges.length; i++) {
//          For self loops. Prevents repetition of nodes. like 3-3, 3-5. So without this it will be. 3-3,3,5. 2 times 3.
            if (edges[i][0] == edges[i][1]) {
                graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
                continue;
            }
//          Coz in undirected graphs, 0-1  --> vertex is both from 0 to 1, and 1 to 0
            graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            graph.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
//        System.out.println(graph);
        return graph;
    }
}

    
//  This is for graphs, where we have weights. So it stores the destination node and the weights
class Pair implements Comparator<Pair>{
        int node, weight;
        Pair(){}

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

    @Override
    public int compare(Pair p1, Pair p2) {
        //quick way to implement. For ascending order. See other way too.
        return p1.weight - p2.weight;
    }
}