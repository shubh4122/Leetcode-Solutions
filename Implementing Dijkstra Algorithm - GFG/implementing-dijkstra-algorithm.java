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
        // Write your code here
        //Create Priority Queue
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Pair()); // new Pair() is comparator given to pq to use.
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        //add src to PQ
        pq.add(new Pair(src, 0));
        dist[src] = 0;

/*
        |--------------------------------------------------------|
        |        ******** FINDING SHORTEST PATH ********         |
        |                                                        |
        |      Do below steps: UNTIL pq is empty                 |
        |       1. Pop the node(with least dist). Property of pq |
        |       2. Visit all adj nodes of Popped node            |
        |       3. Calc newDist, if its Lower:                   |
        |               a. Update it in dist[]                   |
        |               b. Push this node Pair in PQ             |
        |--------------------------------------------------------|
*/
        while (!pq.isEmpty()) {
            Pair topNode = pq.remove();
            int leastDistNode = topNode.node;
            int leastDist = topNode.weight;

            for (int i = 0; i < graph.get(leastDistNode).size(); i++) {
                int adjNode = graph.get(leastDistNode).get(i).get(0);
                int adjWeight = graph.get(leastDistNode).get(i).get(1);

                int newDist = dist[leastDistNode] + adjWeight;
                if (newDist < dist[adjNode]) {
                    dist[adjNode] = newDist;
                    //node pushed to PQ with new updated DIST.
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        return dist;

    }
    
    static class Pair implements Comparator<Pair>{
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
}

