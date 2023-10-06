//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    //O(1) space method.
    public static void rearrange(Node head)
    {
        if(head.next == null)
            return;
        //connect the alternates first.
        Node ptr1 = head, ptr2 = head.next;
        Node tail1 = ptr1, head2 = ptr2;
        
        while(ptr1 != null && ptr2 != null){
            ptr1.next = ptr2.next;
            tail1 = ptr1;
            ptr1 = ptr1.next;
            if(ptr1 != null){
                ptr2.next = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        if(ptr1 != null)
            tail1 = ptr1;
        // Reverse head2.
        tail1.next = reverse(head2);
    }

    static Node reverse(Node head){
        Node prev = null, curr = head, next;
        
        while(curr!=null){
            next = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
