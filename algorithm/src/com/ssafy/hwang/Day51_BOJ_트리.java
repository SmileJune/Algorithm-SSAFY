package com.ssafy.hwang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day51_BOJ_트리 {
	static List<Integer> deleteNodeNumber;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		deleteNodeNumber = new ArrayList<>();
		int[][] tree = new int[N][3];
		for (int i = 0; i < N; i++) {
			tree[i] = new int[] { -1, -1, -1 };
		}

		for (int i = 0; i < N; i++) {
			int parent = sc.nextInt();
			tree[i][2] = parent;
			if (parent != -1) {
				if (tree[parent][0] == -1) {
					tree[parent][0] = i;
				} else {
					tree[parent][1] = i;
				}
			}
		}
		int cnt = 0;
		// 삭제노드의 부모가 삭제노드 연결끊기
		int delete = sc.nextInt();
		deleteNodeNumber.add(delete);
		if (tree[delete][2] != -1) {
			if (tree[tree[delete][2]][0] == delete) {
				tree[tree[delete][2]][0] = -1;
			} else {
				tree[tree[delete][2]][1] = -1;
			}
		}
		while (true) {
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				// 부모가 삭제노드이면
				if (deleteNodeNumber.contains(tree[i][2])) {
					if (deleteNodeNumber.contains(tree[i][0]) && deleteNodeNumber.contains(tree[i][1]))
						continue;
					// 삭제노드에 추가하고
					deleteNodeNumber.add(i);
					// 부모에서 노드 연결끊기
					if (tree[tree[i][2]][0] == i) {
						flag = true;
						tree[tree[i][2]][0] = -1;
					} else if (tree[tree[i][2]][1] == i) {
						flag = true;
						tree[tree[i][2]][1] = -1;
					}

				}

			}
			if (!flag)
				break;
		}

		for (int i = 0; i < N; i++) {
			if (deleteNodeNumber.contains(i)) {
				continue;
			}
			// 삭제노드가 아닌것중에 리프노드면 cnt++
			if (tree[i][0] == -1 && tree[i][1] == -1) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}