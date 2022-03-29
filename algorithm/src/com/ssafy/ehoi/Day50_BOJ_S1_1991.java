package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

public class Day50_BOJ_S1_1991 {

//	static class Node {
//		int node;
//		String v, l, r;
//	}

	// 아.. 점이 아스키코드로 -19이구나..?
	static int[][] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 노드 개수 입력
		int N = sc.nextInt();
		sc.nextLine();
		// 루트 인덱스를 1로 쓸 거니까 하나 크게 배열 생성
		tree = new int[N + 1][3];
		String[][] tmp = new String[N + 1][3];
		for (int i = 1; i <= N; i++) {
			tmp[i] = sc.nextLine().split(" ");
			int idx = tmp[i][0].charAt(0) - 'A' + 1;
			tree[idx][0] = tmp[i][0].charAt(0) - 'A' + 1;
			tree[idx][1] = tmp[i][1].charAt(0) - 'A' + 1;
			tree[idx][2] = tmp[i][2].charAt(0) - 'A' + 1;
		} // 입력 끝
//		System.out.println(Arrays.deepToString(tree));
		
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
		System.out.println();

		sc.close();
	}

	public static void preorder(int curr) {
		// 전위 순회 v l r 순으로 출력
		// 1. 내 노드
		System.out.print((char)(tree[curr][0]+'A'-1));
//		System.out.print(tree[curr][0]);
		// 2. 왼쪽 노드
		// 일단 존재하는지 확인 해야하고
		if (tree[curr][1] !=  ('.'-'A'+1)) { // . 과 다르다면 존재한다는 거니까
			// 존재한다면 자식이 있을지도 모르니까 얘도 다시 던져
			preorder(tree[curr][1]);
		}
		// 3. 오른쪽 노드
		if (tree[curr][2] !=  ('.'-'A'+1)) {
			preorder(tree[curr][2]);
		}

	}
	
	public static void inorder(int curr) {
		// 중위 순회
		// 왼
		// 있는지 확인하고 .이 아니면 돼 // 있으면 자식이 있을지도 모르니 재귀 던지기
		if (tree[curr][1] != ('.'-'A'+1)) inorder(tree[curr][1]);
		
		// 나
		System.out.print((char)(tree[curr][0]+'A'-1));
		
		// 오
		if (tree[curr][2] != ('.'-'A'+1)) inorder(tree[curr][2]);
	}
	
	public static void postorder(int curr) {
		// 후위 순회
		// 왼
		// 있는지 확인하고 .이 아니면 돼 // 있으면 자식이 있을지도 모르니 재귀 던지기
		if (tree[curr][1] != ('.'-'A'+1)) postorder(tree[curr][1]);
		
		// 오
		if (tree[curr][2] != ('.'-'A'+1)) postorder(tree[curr][2]);

		// 나
		System.out.print((char)(tree[curr][0]+'A'-1));
		
	}
}
