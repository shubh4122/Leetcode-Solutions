//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int n, ArrayList<ArrayList<ArrayList<Integer>>> graph, int src)
    {
        PriorityQueue<Pair> q = new PriorityQueue(new Pair());//this is Comparator
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.add(new Pair(src, 0));
        dist[src] = 0;

        while (!q.isEmpty()) {
            Pair p = q.remove();
            int node = p.first;
            int wt = p.second;

            for (ArrayList<Integer> adj : graph.get(node)) {
                int adjNode = adj.get(0);
                int adjWt = adj.get(1);
                
                //Relaxation
                int newDist = dist[node] + adjWt;
                if (newDist < dist[adjNode]){
                    dist[adjNode] = newDist;
                    q.add(new Pair(adjNode, adjWt));
                }
            }
        }
        return dist;

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

