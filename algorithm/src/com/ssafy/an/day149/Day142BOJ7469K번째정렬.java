package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Day142BOJ7469K번째정렬 { // 7469 K번째 수, 구 선생님 도움
	static final int MAXN = 100005;
	static int N, M;
	static int[] A = new int[MAXN];
	static ArrayList<Integer> v = new ArrayList<>();
	static Node[] Tree = new Node[MAXN];

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= N; i++) {
			v.add(A[i] = Integer.parseInt(st.nextToken()));
		}

		Collections.sort(v);

		Tree[0] = new Node(0);
		Tree[0].left = Tree[0].right = Tree[0];

		for (int i = 1; i <= N; i++) {
			A[i] = Collections.binarySearch(v, A[i]) + 1;
			Tree[i] = update(Tree[i - 1], 1, N, A[i], 1);
		}

		int from, to, kth, position;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			kth = Integer.parseInt(st.nextToken());
			position = query(Tree[from - 1], Tree[to], 1, N, kth);

			System.out.println(v.get(position - 1));
		}
	}

	static int query(Node from, Node to, int low, int high, int kth) {
		if (low == high) {
			return low;
		}

		int mid = (low + high) >> 1;
		int leftValue = to.left.value - from.left.value;

		if (kth <= leftValue) {
			return query(from.left, to.left, low, mid, kth);
		} else {
			return query(from.right, to.right, mid + 1, high, kth - leftValue);
		}
	}

	public static Node update(Node now, int low, int high, int index, int value) {
		if (index < low || high < index) {
			return now;
		}

		if (low == high) {
			return new Node(now.value + value);
		}

		int mid = (low + high) >> 1;

		return new Node(now.value + value, update(now.left, low, mid, index, value),
				update(now.right, mid + 1, high, index, value));
	}

	static class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
		}

		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
}