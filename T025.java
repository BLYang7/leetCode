package com.blyang;
/**
 * 反转链表
 *
 * 给定反转的数字K，前K个反转，后面的保持不变
 */
public class T025 {
	
	//链表类
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	
    public ListNode reverseKGroup(ListNode head, int k) {
    	// delete special case
        if (k == 1 || head == null || head.next == null){
        	return head;
        }
            
        ListNode first = head, last = head;
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode preGroup = preHead, nextGroup = preHead;
        
        int count = 1;
        while (last != null) {
            if (count == k) {
                nextGroup = last.next;
                reverseList(first, last);
                preGroup.next = last;
                preGroup = first;
                first.next = nextGroup;
                first = nextGroup;
                last = nextGroup;
                count = 1;
                continue;
            }
            last = last.next;
            count++;
        }
        return preHead.next;
    }

    private void reverseList(ListNode head, ListNode tail) {
        ListNode pre = new ListNode(-1), node = head;
        pre.next = head;
        while (pre != tail) {
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node = temp;
        }
    }
    
    public static void main(String[] args) {
    	
    	T025 t = new T025();
		T025.ListNode head = new T025().new ListNode(1);
		T025.ListNode h2 = new T025().new ListNode(2);
		T025.ListNode h3 = new T025().new ListNode(3);
		T025.ListNode h4 = new T025().new ListNode(4);
		T025.ListNode h5 = new T025().new ListNode(5);
		head.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		
		T025.ListNode temp = head;
		while(temp != null){
			System.out.print(temp.val);
			temp = temp.next;
			if(temp != null){
				System.out.print("-->");
			}
		}
		System.out.println();
		T025.ListNode result0 = t.reverseKGroup(head, 2);
		while(result0 != null){
			System.out.print(result0.val);
			result0 = result0.next;
			if(result0 != null){
				System.out.print("-->");
			}
		}
		System.out.println();
		T025.ListNode result1 = t.reverseKGroup(head, 4);
		while(result1 != null){
			System.out.print(result1.val);
			result1 = result1.next;
			if(result1 != null){
				System.out.print("-->");
			}
		}
		
	}
    
    
}
