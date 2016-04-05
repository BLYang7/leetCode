package com.blyang;
/**
 * 删除链表中倒数第N个节点
 * 
 * 链表的倒数第N个，也就是正数的第Length－N＋1个
 * 这也就是说，第Length－N的next是Length－N＋2；
 * 直接遍历即可，关键是处理好序列数字
 */
public class T019 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			if (head == null){
				return null;
			}
			// get length of list
			ListNode p = head;
			int len = 0;
			while (p != null) {
				len++;
				p = p.next;
			}
			// if remove first node
			int fromStart = len - n + 1;
			if (fromStart == 1){
				return head.next;
			}
			// remove non-first node
			p = head;
			int i = 0;
			while (p != null) {
				i++;
				if (i == fromStart - 1) {
					p.next = p.next.next;
				}
				p = p.next;
			}
			return head;
		}
	}

}
