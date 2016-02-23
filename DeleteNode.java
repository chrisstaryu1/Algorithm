package com.leetcode.Node;

public class DeleteNode {
	public void delete(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
