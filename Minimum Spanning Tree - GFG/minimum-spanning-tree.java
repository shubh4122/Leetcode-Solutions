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
	    //Step1 - sort edges about wt
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];//index [i][2] is weight of corresponding edge
            }
        });
        
        //Step 2: use disjoint set, and make connections
        DisjointSet ds = new DisjointSet(n);
        int mstWt = 0;

        for (int[] edge : edges) {
            if (ds.findUltParent(edge[0]) != ds.findUltParent(edge[1])) {
                mstWt += edge[2];
                ds.unionByRank(edge[0], edge[1]);
            }
        }
        return mstWt;
	}
	
	
    static class DisjointSet {
        ArrayList<Integer> rank = new ArrayList<>();
        ArrayList<Integer> parent = new ArrayList<>();
    
        //made public for it to be accessible outside package
        public DisjointSet(int numOfNodes) {
            for (int i = 0; i < numOfNodes + 1; i++) { // +1 to support 1 based indexing too
                rank.add(0); //Default values
                parent.add(i);
            }
        }
    
        public int findUltParent(int node) {//finding ultimate parent
            if (node == parent.get(node))
                return node;
    
            int ulp = findUltParent(parent.get(node));
            //it REPLACES val at index node with val ULP
            parent.set(node, ulp);
            return parent.get(node);
        }
    
        public void unionByRank(int u, int v) {
    /*
             ----------------------------------------------
            |                 Union Algo                   |
            |     1. Find ult Parent of u,v (pu, pv)       |
            |     2. Find RANK of pu, pv                   |
            |     3. Attach smaller rank ultimate parent   |
            |        to larger Rank ultimate Par           |
             ----------------------------------------------
     */
            int pu = findUltParent(u);
            int pv = findUltParent(v);
    
            //if pu and pv of both same, then no need to union them
            if (pu == pv)   return;
    
            if (rank.get(pu) < rank.get(pv)) {
                parent.set(pu, pv); // Make pv as Parent of pu, That is attach pu to pv.
                //Rank of pv doesnt change coz it was already higher. so it wouldnt cause any change
            }
            else if (rank.get(pu) > rank.get(pv)) {
                parent.set(pv, pu);
            }
            else {//when both rank equal, then join any to any, and increase RANK of final UltPar
                parent.set(pv, pu);
                rank.set(pu, rank.get(pv)+1);//or rank[pu] + 1 will be same
            }
        }
    }
}