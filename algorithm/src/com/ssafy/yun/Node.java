package com.ssafy.yun;

public class Node {
	public int data;
	public Node link;

	public Node() {
		super();
	}

	public Node(int data) {
		super();
		this.data = data;
	}

	public Node(int data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}
}
