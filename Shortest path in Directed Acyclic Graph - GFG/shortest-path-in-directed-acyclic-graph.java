//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int n,int M, int[][] edges) {
		//Code here
		
		return edgesToList_Directed_Weighted(edges, n);
		
	}
	
	

    public int[] edgesToList_Directed_Weighted(int[][] edges, int n) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Pair>());
        }
    
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
        
        int dist[] = new int[n];
        int src = 0; //Here it's same always
        shortestDist_DAG_Weighted_using_TOPOSORT(graph, n, dist, src);
        
        return dist;
    }
    
    
    
    public void shortestDist_DAG_Weighted_using_TOPOSORT(ArrayList<ArrayList<Pair>> graph, int n, int[] dist, int src) {
//        |----------------------------------------------|
//        |        Step 1 - TOPO SORT, for sequence      |
//        |----------------------------------------------|

        //This solution is slightly different from my solution.
        //It uses TOPOSORT for the order in which nodes are visited
        int[] topoSort = new int[n];
        boolean[] vis = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int node = 0; node < n; node++) {
            if (!vis[node])
                topoDFS_weighted(graph, vis, node, stack);
        }


//        |--------------------------------------------------------|
//        |        ******** FINDING SHORTEST PATH ********         |
//        |                                                        |
//        |      Step 2 - Pop from stack, and visit this node.     |
//        |               Update its dist, if lesser.              |
//        |               Visit, its immediate adjNodes            |
//        |--------------------------------------------------------|

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!stack.isEmpty()) {
            int top = stack.pop(); // elem popped will be in topo order. i.e. 1st popped elem points to other following it.

            //NOTE : this if condition is for, if src and TOP of Stack aren't same.
            //We'll start doing the inner process, only after the src is popped.
            if (dist[top] != Integer.MAX_VALUE) { //V IMP.
                for (Pair adjNode : graph.get(top)) {
                    int newDist = dist[top] + adjNode.weight; //adjNode.weight means, weight req to reach adj from top

                    if (newDist < dist[adjNode.node]){ // replace with lesser distance
                        dist[adjNode.node] = newDist;
                    }
                }
            }
        }

        //This is just to replace INF with -1. QUES Requirement
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }

    }

    
    //below toposort is for directed graphs, where we have Pair and not int.
    public void topoDFS_weighted(ArrayList<ArrayList<Pair>> graph, boolean[] vis, int node, Stack<Integer> stack){
        if (!vis[node]) {
            vis[node] = true;
            for (Pair adjNode : graph.get(node)) {
                topoDFS_weighted(graph, vis, adjNode.node, stack);
            }
        //  Uptil now, completely same as DFS code
        //  Below adding node to stack.
            stack.push(node);
        }
    }
    
    
    
    class Pair{
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}