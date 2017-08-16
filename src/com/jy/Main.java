package com.jy;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 定义链表输入1->2->3->4->5->6
		ListNode node6 = new ListNode(6, null);
		ListNode node5 = new ListNode(5, node6);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
		// 头结点
		ListNode head = node1;
		// 获取输入
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入k的值:");
		int k = scanner.nextInt();

		System.out.print("正向输出链表：");
		ListNode listNode = head;
		while (listNode.mNext != null) {
			System.out.print(listNode.mValue + "->");
			listNode = listNode.mNext;
		}
		System.out.println(listNode.mValue);
		ListNode kThToTailNode = findKthToTail(head, k);
		System.out.print("倒数第" + k + "个元素为：" + (kThToTailNode != null ? kThToTailNode.mValue : null));
		// 关闭资源
		scanner.close();
	}

	/**
	 * 遍历一次查找链表的倒数第k个元素
	 * 
	 * @param head
	 *            头结点
	 * @param k
	 * @return 倒数第k个节点
	 */
	public static ListNode findKthToTail(ListNode head, int k) {
		// 鲁棒性检查
		if (head == null || k == 0)
			return null;
		// 定义前后两个节点，间隔为k-1
		ListNode ahead = head;
		ListNode behind = null;
		// 前面的节点先向前移动k-1步
		for (int i = 0; i < k - 1; i++) {
			if (ahead.mNext != null)
				ahead = ahead.mNext;
			else
				// 如果链表元素总和小于k，则直接返回null
				return null;
		}
		// 后面的节点再开始移动
		behind = head;
		// 然后两个节点同时向后移动，知道链表尾
		while (ahead.mNext != null) {
			ahead = ahead.mNext;
			behind = behind.mNext;
		}
		// 当前一个节点到达尾部时，后一个节点刚好处于倒数第k个节点的位置
		return behind;
	}
}
