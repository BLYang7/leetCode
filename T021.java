package com.blyang;

/**
 * 链表的合并
 */
public class T021 {

	// 链表类
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// 合并方法
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		ListNode p1 = l1;
		ListNode p2 = l2;

		ListNode fakeHead = new ListNode(0);
		ListNode p = fakeHead;

		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}

			p = p.next;
		}

		if (p1 != null)
			p.next = p1;
		if (p2 != null)
			p.next = p2;

		return fakeHead.next;
	}

}