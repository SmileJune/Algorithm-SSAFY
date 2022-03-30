package com.ssafy.hwang;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author kwan 목표 : 이진트리에서 주어진 두 정점의 최소크기의 공통 조상노드를 찾아라.
 * 
 *         입력 : testcase 수 V E n1 n2 (정점 총 수, 간선 총 수, 정점1, 정점2) E개의 간선이 나열된다.
 * 
 *         접근법 : 노드 객체를 만들어서 각 노드의 조상값을 표기해두고, 자식은 왼쪽부터 채우자. 
 *                  방문하는 노드를 체크하여 만약 중복체크된다면 그것을 최소크기의 공통 조상노드라 판단한다. 
 *                  정점 갯수 구하는 것은 찾은 공통의 조상노드부터 시작하여 VLR로 순회하고 cnt를 늘려준다.
 *                  (루트노드도 포함해야한다)
 */

class Node {
	int parent;
	int left;
	int right;
}

public class Day50_SW_공통조상 {
	static Node[] tree;
	private static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			visited = new boolean[V + 1];
			tree = new Node[V + 1];
			for (int i = 1; i <= V; i++) {
				tree[i] = new Node();
            }
			// 한줄로 들어오는 간선 정보(부모-자식 쌍)로 트리 채워주기.
			st = new StringTokenizer(sc.nextLine());
			for (int i = 0; i < E; i++) {
				int parent = Integer.parseInt(st.nextToken());
				int son = Integer.parseInt(st.nextToken());

				// 자식은 왼쪽부터 채워보자
				if (tree[parent].left != 0) {
					tree[parent].right = son;
					tree[son].parent = parent;
					continue;
				}
				tree[parent].left = son;
				tree[son].parent = parent;
			}
			int root = 1;
			while (true) {
				if (n1 != 1) {
					int parent = tree[n1].parent;
					if (visited[parent]) {
						root = parent;
						break;
					}
					visited[parent] = true;
					n1 = parent;
				}
				if (n2 != 1) {
					int parent = tree[n2].parent;
					if (visited[parent]) {
						root = parent;
						break;
					}
					visited[parent] = true;
					n2 = parent;
				}

			}
			System.out.printf("#%d %d %d\n",tc, root, preorder(root,0));
		}
	}
	
	static int preorder(int i, int cnt) {
		cnt ++;
		if(tree[i].left!=0) {
			cnt = preorder(tree[i].left,cnt);
		}
		if(tree[i].right!=0) {
			cnt = preorder(tree[i].right,cnt);
		}
		return cnt;
	}
}











