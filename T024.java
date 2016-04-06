package com.blyang;
/**
 * 链表点偶数个相互交换
 * 
 * 但是每次交换之后，要给一个临时变量，保存链表的next值
 */
public class T024 {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
        
		if(head == null || head.next == null){  
            return head;  
        }
		
        ListNode p,q,s,t;  
        q = head;  
        p = head.next;
        
        if(p.next == null || p.next.next == null){  
            head = p;  
        }  
        
        int count = 0;  
        while(p.next != null && p.next.next != null){  
            s = p.next;  
            q.next = s;  
            p.next = q;  
            t = q;  
            
            if(count==0) {
            	head = p;  
            }
            
            count++;  
            q = s;  
            p = q.next;  
            t.next = p;  
        }  
        
        t = p.next;  
        p.next = q;  
        q.next = t;  
        return head; 
	}
}
