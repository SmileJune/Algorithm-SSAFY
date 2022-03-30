package com.ssafy.namja;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_1248_박성현 {
	static int V;
	static int n = 1;
	static int[][] child;
	static int[] nChild;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			V = sc.nextInt();
			int E = sc.nextInt();
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			child = new int[V + 1][2];
			nChild = new int[V + 1];
			int[] order = new int[V];
			for (int i = 0; i < E; i++) {
				int node = sc.nextInt();
				child[node][nChild[node]++] = sc.nextInt();
			}
			
			ArrayList<Integer> path1 = new ArrayList<>();
			ArrayList<Integer> path2 = new ArrayList<>();
			
			makePath(path1, node1);
			makePath(path2, node2);
			
			int root = 0;
			outer: for (int i : path1) {
				for (int j : path2) {
					if (i == j) {
						root = i;
						break outer;
					}
				}
			}
//			System.out.println(root);
			getCount(root);
			System.out.printf("#%d %d %d\n", t, root, n);
		}
	}
	
	static void makePath(ArrayList path, int node) {
		outer: for (int i = 1; i <= V; i++) {
			for (int j = 0; j < 2; j++) {
				if (child[i][j] == node) {
					path.add(node);
					node = i;
					i = 0;
					if (node == 1) {
						path.add(node);
						break outer;
					}
					continue outer;
				}
			}
		}
	}
	
	static void getCount(int root) {
		if (nChild[root] == 0)
			return;
		n += nChild[root];
		for (int i = 0; i < 2; i++) {
			if (child[root][i] == 0)
				continue;
			getCount(child[root][i]);
		}
	}
}