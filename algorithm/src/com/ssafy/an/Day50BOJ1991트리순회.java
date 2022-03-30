package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day50BOJ1991트리순회 { // 1991 트리 순회
	static List<Node>[] list;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		list = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = st.nextToken().charAt(0) - 'A';
			int left = st.nextToken().charAt(0) - 'A';
			int right = st.nextToken().charAt(0) - 'A';
			list[idx].add(new Node(left, right));
		}
		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);
		sb.append("\n");

		System.out.println(sb);
		br.close();
	}

	private static void preorder(int st) {
		for (Node node : list[st]) {
			int l = node.left;
			int r = node.right;

			sb.append((char) (st + 'A'));
			if (l != -19)
				preorder(l);
			if (r != -19)
				preorder(r);
		}
	}

	private static void inorder(int st) {
		for (Node node : list[st]) {
			int l = node.left;
			int r = node.right;

			if (l != -19)
				inorder(l);
			sb.append((char) (st + 'A'));
			if (r != -19)
				inorder(r);
		}
	}

	private static void postorder(int st) {
		for (Node node : list[st]) {
			int l = node.left;
			int r = node.right;

			if (l != -19)
				postorder(l);
			if (r != -19)
				postorder(r);
			sb.append((char) (st + 'A'));
		}
	}

	static class Node {
		int left;
		int right;

		public Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
}
