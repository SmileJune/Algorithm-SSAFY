package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day51BOJ5639이진트리탐색인덱스버전 {
	static int[] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		tree = new int[10001];
		sb = new StringBuilder();
		int idx = 0;
		while (true) {
			String n = br.readLine();
			if(n == null) break;
			tree[idx++] = Integer.parseInt(n);
		}
		postOrder(0, idx - 1);
		System.out.println(sb);
		br.close();
	}

	static void postOrder(int idx, int end) {
		if (idx > end)
			return;

		int mid = idx + 1;
		while (mid <= end && tree[mid] < tree[idx])
			mid++;

		postOrder(idx + 1, mid - 1);
		postOrder(mid, end);
		sb.append(tree[idx]).append("\n");
	}
}
