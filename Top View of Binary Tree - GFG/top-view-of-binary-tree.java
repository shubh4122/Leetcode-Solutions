//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        TreeMap<Integer, Integer> map = new TreeMap<>();//key:dist, val:node
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> tv = new ArrayList<>();
        int currDist = 0, parentDist = -1;

        map.put(currDist, root.data);
        q.add(new Pair(root, currDist));
        while (!q.isEmpty()) {
            Pair popped = q.remove();
            Node poppedNode = (Node) popped.first;
            parentDist = (int)popped.second;

            if (poppedNode.left != null) {
                currDist = parentDist - 1;
                q.add(new Pair(poppedNode.left, currDist));
                if (!map.containsKey(currDist))
                    map.put(currDist, poppedNode.left.data);
            }
            if (poppedNode.right != null) {
                currDist = parentDist + 1;
                q.add(new Pair(poppedNode.right, currDist));
                if (!map.containsKey(currDist))
                    map.put(currDist, poppedNode.right.data);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            tv.add(entry.getValue());
        }

        return tv;
    }
    
    
    public static class Pair<T, S> {
        public T first;
        public S second;

        public Pair(T first, S second) {
            this.first = first;
            this.second = second;
        }
    }
}