/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
     ListNode result=new ListNode(0);
     if(l1==null){
         return l2;
     }   
        if(l2==null){
            return l1;
        }
        ListNode mynode=result;
        
        while(l1!=null &&l2!=null){
            if(l1.val<l2.val){
                mynode.next=l1;
                l1=l1.next;
                mynode=mynode.next;
            }
            else{
                mynode.next=l2;
                l2=l2.next;
                mynode=mynode.next;
            }
        }
        
        while(l1!=null){
            mynode.next=l1;
            l1=l1.next;
            mynode=mynode.next;
        }
        
            while(l2!=null){
                mynode.next=l2;
            l2=l2.next;
                mynode=mynode.next;
        }
        
        
        return result.next;
    }
}