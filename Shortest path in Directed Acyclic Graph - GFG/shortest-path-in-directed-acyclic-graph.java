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

	public int[] shortestPath(int n,int m, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> graph = edgesToList_Directed_Weighted(edges, n);
		Queue<Pair> q = new LinkedList<>();//[node, its distance from parent]
		int[] dist = new int[n];//dist b/w src(0) and node(idx)
		Arrays.fill(dist, (int)1e9);
		
		dist[0] = 0;
		
		q.add(new Pair(0, 0));
		
		while(!q.isEmpty()){
		    Pair pop = q.remove();
		    int parent = pop.node;
		    
		    for(Pair adj : graph.get(parent)) {
		        int adjNode = adj.node;
		        int adjNodeDist = adj.weight;
		        
    		    //relaxation
    		    //new dist = dist of parent from src + dist b/w parent and adjnode
    		    //i.e. new dist = dist[parent of adjNode] + adjnodeDist
    		    if(dist[adjNode] > dist[parent]+adjNodeDist){
    		        dist[adjNode] = dist[parent]+adjNodeDist;
    		        //add this adjnode to queue so, dist of its children is recalculated
    		        q.add(adj);
    		    }
		    }
		}
		for(int i = 0; i < dist.length; i++){
		    if(dist[i] == (int) 1e9)
		        dist[i] = -1;
		}
		return dist;
	}
	
	public ArrayList<ArrayList<Pair>> edgesToList_Directed_Weighted(int[][] edges, int n) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
//        System.out.println(graph);
        return graph;
    }
    
    class Pair{
        int node, weight;
        Pair(int n, int w){
            node = n;
            weight = w;
        }
    }
}