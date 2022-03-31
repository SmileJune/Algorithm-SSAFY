package com.ssafy.hwang;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Day51_BOJ_트리순회 {
	static class Node {
		int left;
		int right;
		String data;
		int index;
	}

	static int N;
	static Node[] tree;
	static StringBuilder sb;

	public static void main(String[] args) {
		sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		tree = new Node[N + 1];
		String c = ".ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 1; i <= N; i++) {
			Node node = new Node();
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			String data = st.nextToken();
			node.data = data;
			node.index = c.indexOf(data);
			node.left = c.indexOf(st.nextToken());
			node.right = c.indexOf(st.nextToken());

			tree[node.index] = node;
		}
		preorder(1);
		sb.append("\n");
		inorder(1);
		sb.append("\n");
		postorder(1);
		sb.append("\n");
		System.out.println(sb.toString());
	}

	private static void postorder(int i) {

		if (tree[i].left != 0)
			postorder(tree[i].left);
		if (tree[i].right != 0)
			postorder(tree[i].right);
		sb.append(tree[i].data);
	}

	private static void inorder(int i) {
		if (tree[i].left != 0)
			inorder(tree[i].left);
		sb.append(tree[i].data);
		if (tree[i].right != 0)
			inorder(tree[i].right);
	}

	static void preorder(int i) {
		sb.append(tree[i].data);
		if (tree[i].left != 0)
			preorder(tree[i].left);
		if (tree[i].right != 0)
			preorder(tree[i].right);
	}
}