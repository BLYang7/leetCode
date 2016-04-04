package com.blyang;
/**
 * 考察链表的使用
 * 		1、两个链表的相加
 */

public class T002 {
	
	//链表类
    private class ListNode {
   	 	int val;
   	 	ListNode next;
   	 	ListNode(int x) { val = x; }
    }

    //两个链表相加
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helpler(l1, l2, 0);
    }
    
    //帮助类
    public ListNode helpler(ListNode l1, ListNode l2, int k){
        
        if(l1 == null && l2 == null){
            return k == 0 ? null : new ListNode(k);
        }
        
        if(l1 == null && l2  != null){
            l1 = new ListNode(0);
        }
        
        if(l1 != null && l2 == null){
            l2 = new ListNode(0);
        }
        
        int sum = l1.val + l2.val + k;
        
        ListNode curr = new ListNode(sum % 10);
        curr.next = helpler(l1.next, l2.next, sum/10);
        return curr;
    }
    
    

    
}
