//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int n, ArrayList<ArrayList<Integer>> graph)
    {
        // Code here
        //      Here thing to NOTE is, we use color arr instead of Visited. Color arr keeps track of both color and visited
//      0 : Not visited,
//     -1 : Color 1,
//      1 : Color 2
        int[] color = new int[n];
        Queue<Integer> q = new ArrayDeque<>();

        for (int node = 0; node < n; node++) {
            if (color[node] == 0) //not visited
            {
                q.add(node);
                color[node] = 1;

                while (!q.isEmpty()) {
                    int temp = q.remove();
                    int previousNode = temp;
                    for (int adjNode : graph.get(temp)) {
                        if (color[adjNode] == 0) { //not visited
                            q.add(adjNode);
                            color[adjNode] = -(color[previousNode]);
                        }
                        
                        if (color[temp] == color[adjNode])
                            return false;
                    }
                }
            }
        }
        return true;
    }
}