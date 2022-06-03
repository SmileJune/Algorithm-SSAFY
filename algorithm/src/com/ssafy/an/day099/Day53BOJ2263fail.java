package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day53BOJ2263fail {
	static int[] getRootIdx;
	static int[] inOrder;
	static int[] postOrder;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());

		getRootIdx = new int[N+1];
		inOrder = new int[N];
		postOrder = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			getRootIdx[inOrder[i]] = i;
		}

		getPreOrder(0, N - 1, 0, N - 1);
		// 결국 재귀 방식은 구선생님 도움..
		System.out.println(sb);
		br.close();
	}

	private static void getPreOrder(int ist, int ied, int pst, int ped) {
		if (ist > ied || pst > ped)
			return;

		int root = postOrder[ped];
		sb.append(root).append(" ");

		int inRoot = getRootIdx[root];
		int leftChild = inRoot - ist;
		getPreOrder(ist, inRoot - 1, pst, pst + leftChild - 1);
		getPreOrder(inRoot + 1, ied, pst + leftChild, ped - 1);
	}
}
// 1 2 3 4 5 6 7
// preorder		: 1 2 4 5 3 6 7 

// inorder		: 4 2 5 1 6 3 7
// postorder	: 4 5 2 6 7 3 1
// getRootIdx	: 4 2 6 1 3 5 7 from inorder
/*
 * 
7
4 2 5 1 6 3 7
4 5 2 6 7 3 1

 */
