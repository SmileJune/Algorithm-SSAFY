package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day51BOJ5639이진트리탐색노드구현 {
	static class Node {
		int idx;
		Node l, r;

		Node(int idx) {
			this.idx = idx;
		}

		void insert(int num) {
			if (num < this.idx) {
				if (this.l == null) {
					this.l = new Node(num);
				} else {
					this.l.insert(num);
				}
			} else {
				if (this.r == null) {
					this.r = new Node(num);
				} else {
					this.r.insert(num);
				}
			}
		}
	}

	static int[] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		Node root = new Node(Integer.parseInt(br.readLine()));
		while (true) {
			String n = br.readLine();
			if (n == null)
				break;
			root.insert(Integer.parseInt(n));
		}
		postOrder(root);
		System.out.println(sb);
		br.close();
	}

	static void postOrder(Node node) {
		if(node.l!=null)
			postOrder(node.l);
		if(node.r!=null)
			postOrder(node.r);
		sb.append(node.idx).append("\n");
	}
}
