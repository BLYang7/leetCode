package com.blyang;
/**
 * 多个有序链表的组合
 * 
 * 有两种方法
 * 方法一：融合两个链表，然后遍历，不断去融合下一个
 * 方法二：use a priority queue. We can add the heads of all lists in to the queue. And we can poll out the smallest one. 
 * 		  If the next node of this smallest node is not null, we can add the next node to the queue.We will continue 
 * 		  doing this until the queue is empty.
 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class T023 {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
//方法一：写一个重组两个List的方法，然后遍历所有的ListNode数组
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode p1 = l1;
//		ListNode p2 = l2;
//
//		ListNode fakeHead = new ListNode(0);
//		ListNode p = fakeHead;
//
//		while (p1 != null && p2 != null) {
//			if (p1.val <= p2.val) {
//				p.next = p1;
//				p1 = p1.next;
//			} else {
//				p.next = p2;
//				p2 = p2.next;
//			}
//
//			p = p.next;
//		}
//
//		if (p1 != null)
//			p.next = p1;
//		if (p2 != null)
//			p.next = p2;
//
//		return fakeHead.next;
//    }
//	
//	public ListNode mergeKLists(ListNode[] lists) {
//		
//		ListNode resNode = new ListNode(Integer.MIN_VALUE);
//		
//		for(int i=0; i<lists.length; i++){
//			resNode = mergeTwoLists(resNode, lists[i]);
//		}
//		
//		return resNode.next;
//	}
	
	
//	方法二
//	The second one is to use a priority queue. 
//  We can add the heads of all lists in to the queue. And we can poll out the smallest one. 
//	If the next node of this smallest node is not null, we can add the next node to the queue.
//	We will continue doing this until the queue is empty.
    public ListNode mergeKLists(ListNode[] lists) {
    	
        if (lists.length == 0){
        	return null;
        }
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        
        //将lists中的所有链表的第一个加入到优先级队列中
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null){
            	queue.add(lists[i]);
            }
        }
 
        // 利用优先级队列新建链表
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();  //弹出最小value的点
            p.next = node;
            if (node.next != null){
            	queue.add(node.next);
            }
            p = p.next;
        }
        return head.next;
    }
}
