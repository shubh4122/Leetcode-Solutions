//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) 
    {
        ArrayList<ArrayList<Integer>> graph = edgeToList(prerequisites, n);

        boolean vis[] = new boolean[n];
        ArrayList<Integer> topo = new ArrayList<>(n);

        //------------- NOT required, IT GIVES TLE IF USED!! ----------------
        
        //for only disconnected components
//        for (int node = 0; node < n; node++) {
//            if (!vis[node]) {

                //MAIN CODE
                //STEP 1 : calc indegree
                int[] indegree = new int[n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < graph.get(i).size(); j++) {//adj node to parent 'i'
                        indegree[graph.get(i).get(j)]++;
                    }
                }

                Queue<Integer> q = new LinkedList<>();

                //STEP 2 : insert all nodes with indeg 0 to q
                for (int i = 0; i < n; i++)
                    if (indegree[i] == 0)
                        q.add(i);

                //STEP 3 : bfs code
                
                int count = 0;
                while (!q.isEmpty()) {
                    int parent = q.remove();
                    topo.add(parent);
                    count++;
                    
                    for (int adjNode : graph.get(parent)) {
                        indegree[adjNode]--;
                        if (indegree[adjNode] == 0)
                            q.add(adjNode);
                    }
                }
                
                if(count < n)
                    return new int[]{};


        //returning answer
        int[] topoArr = new int[n];

        for (int i = 0; i < n; i++) {
            topoArr[i] = topo.get(i);
        }
        
        // System.out.println(Arrays.toString(topoArr));
        return topoArr;
    }
 
    
    
    public static ArrayList<ArrayList<Integer>> edgeToList(ArrayList<ArrayList<Integer>> edges, int n) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {//<=n because 1 based indexing
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            //Because edge here is Directed hence not both directions
            graph.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }

        return graph;
    }
}