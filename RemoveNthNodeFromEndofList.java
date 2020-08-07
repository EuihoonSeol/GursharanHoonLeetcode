/**
 * Definition for singly-linked list.
 /*
 
The approach here was to use two pointers and keep moving them together.
Let us consider a pointer fast who will stay at a distance of n from the start. Here, 2 cases arise
Case 1 :
n was the length of the given list. Thus fast is now at the end of the list and the element to be removed is the head element.
Here, we assign head as head.next and return head.

Case 2 :
n was a value less than the length of the list. At this moment, our pointer fast is at a distance of n from the start. We take another node slow to be the head. 
Thus slow is the start and fast is at a distance of n from start. If we were to increment both of them together, 
as fast reached the end of the list, slow would be at a distance of n from the end. Thus, we assign slow.next as slow.next.next and return the head.
 
 
 */
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null){
            return null;
        }
        /* n=2
        1 -> 2 ->null, n=2
                  f
        s
        */
       
        ListNode fast=head;
        ListNode slow=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        } 
         if(fast==null){
            head=head.next;
            return head;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
                                        
        
        return head;
    }
}
