package com.ssafy.yun;

public class LinkedListPractice {
	Node head = null;

	public void addFirst(int num) {
		Node node = new Node(num);

		if (head == null) {
			node.link = null;
			head = node;
			return;
		}

		node.link = head;
		head = node;
	}

	public void addLast(int num) {

		if (head == null) {
			addFirst(num);
			return;
		}

		Node node = new Node(num);
		node.link = null;
		Node temp = head;
		while (temp.link != null) {
			temp = temp.link;
		}

		temp.link = node;
	}
}
