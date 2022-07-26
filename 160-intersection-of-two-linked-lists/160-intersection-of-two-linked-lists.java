/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        ListNode ptr1 = head1;
        ListNode ptr2 = head2;
         
         int c1 = 0, c2 = 0;
         
         while(ptr1 != null) {
             c1++;
             ptr1 = ptr1.next;
         }
         while(ptr2 != null) {
             c2++;
             ptr2 = ptr2.next;
         }
         
         int extra = Math.abs(c1-c2);
         ListNode ptrBig = c1 > c2 ? head1 : head2;
         ListNode ptrSmall = ptrBig == head1 ? head2 : head1;
         
         for(int i = 1; i <= extra; i++) {
             ptrBig = ptrBig.next;
         }
         
         while(ptrBig != null) {
             if(ptrBig == ptrSmall) {
                 return ptrBig;
             }
             ptrBig = ptrBig.next;
             ptrSmall = ptrSmall.next;
         }
         return null;
    }
}