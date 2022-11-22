//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int n, ArrayList<ArrayList<Integer>> graph) {
        //      Using Kahn's algo
//      SAME CODE as topoBFS. almost

//      Data structures Required
        int[] indegree = new int[n];
        int[] ans = new int[n];
        Queue<Integer> q = new ArrayDeque<>();

//      Calculating INDEGREE
        for (int node = 0; node < n; node++) {
            for (int adjNode : graph.get(node)) {
                indegree[adjNode]++;
            }
        }

//      whosever in-deg is 0, put them in Queue
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

//      Starting the BFS now.
        int i = 0;
//      This count variable keeps count of how many nodes were popped out of queue
        int count = 0;
        while (!q.isEmpty()) {
//          pop the front of Queue. and store it.
            int temp = q.remove();
            ans[i] = temp;
            i++;
//          increment count with each pop. To count nodes
            count++;

//          Traverse all its Adj nodes
            for (int adjNode : graph.get(temp)) {
                if (indegree[adjNode] != 0) { // THIS is REDUNDANT. Coz, this will always be >= 0. this is simply the count of nodes pointing to this node. THINK!
                    indegree[adjNode]--;
                    if (indegree[adjNode] == 0)
                        q.add(adjNode);
                }
            }
        }

//      If count(or no. of popped nodes = n) then topo sort sequence generated, else not
        if (count == n) {
            return false;
        }
        return true;
    }


}