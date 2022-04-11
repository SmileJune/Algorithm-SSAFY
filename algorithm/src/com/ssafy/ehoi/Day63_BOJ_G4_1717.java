package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day63_BOJ_G4_1717 {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// makeSet
		p = new int[n+1];
		for (int i = 1; i <= n; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			if(op == 0) {
				unionSet(num1, num2);
			} else {
				System.out.println(isSame(num1, num2) ? "YES" : "NO");
			}
		}
	}

	private static boolean isSame(int x, int y) {
		return findSet(x) == findSet(y) ? true : false;
	}

	// 한 대표를 다른 대표의 아래로 넣음
	private static void unionSet(int x, int y) {
		p[findSet(x)] = findSet(y);
	}

	private static int findSet(int x) {
		return p[x] = p[x] == x ? x : findSet(p[x]);
	}
}
