package com.ssafy.BOJ_SB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1991_트리순회 {
	static class Node {
		char self;
		Node left, right;

		public Node(char self) {
			this.self = self;
		}

		public String toString() {
			return self + "";
		}
	}

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		Node[] node = new Node[N];
		char ch = 'A';
		for (int i = 0; i < N; ++i) {
			node[i] = new Node(ch++);
		}
		for (int i = 0; i < N; ++i) {
			char[] line = br.readLine().toCharArray();
			node[line[0] - 65].left = line[2] == '.' ? null : node[line[2] - 65];
			node[line[0] - 65].right = line[4] == '.' ? null : node[line[4] - 65];
		}

		// 전위 출력
		System.out.println(preOrder(node[0]));
		// 중위 출력
		System.out.println(inOrder(node[0]));
		// 후위 출력
		System.out.println(postOrder(node[0]));

	}

	// 전위순회
	private static String preOrder(Node node) {
		String val = "";
		val += node.self;
		if (node.left != null)
			val += preOrder(node.left);
		if (node.right != null)
			val += preOrder(node.right);
		return val;
	}

	// 중위순회
	private static String inOrder(Node node) {
		String val = "";
		if (node.left != null)
			val += inOrder(node.left);
		val += node.self;
		if (node.right != null)
			val += inOrder(node.right);
		return val;
	}

	private static String postOrder(Node node) {
		String val = "";
		if (node.left != null)
			val += postOrder(node.left);
		if (node.right != null)
			val += postOrder(node.right);
		val += node.self;
		return val;
	}

}
