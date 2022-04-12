package com.ssafy.hwang;
import java.util.Scanner;

public class Day64_BOJ_여행가자 {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}

		for (int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				int tmp = sc.nextInt();
				if(tmp ==1) {
					union(i,j);
				}
			}
		}
		String ans = "YES";
		int start = sc.nextInt();
		for(int i=1;i<M;i++) {
			int now = sc.nextInt();
			if(start!=findSet(now)) {
				ans = "NO";
			}
		}
		System.out.println(ans);
	}

	private static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

	private static int findSet(int x) {
		if(p[x]!=x) p[x]= findSet(p[x]);
		return p[x];
	}

	private static void makeSet(int x) {
		p[x] = x;
	}
}
