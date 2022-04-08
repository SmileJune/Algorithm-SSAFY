package com.ssafy.hwang;

import java.util.Scanner;

public class BOJ_쿼드트리 {
	static char[][] map;
	static StringBuilder sb;
	static char check;
	static boolean marked;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		sb = new StringBuilder();
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = sc.nextLine().toCharArray();
		} // 입력끝
		recur(0, 0, N);
		System.out.println(sb.toString());
	}

	private static void recur(int sR, int sC, int n) {
//		if (eR == sR && eC == sC) {
//			sb.append(map[sR][sC]);
//			return;
//		}
		marked = true;
		check = map[sR][sC];
		outer: for (int i = sR; i < sR + n; i++) {
			for (int j = sC; j < sC + n; j++) {
				if (check != map[i][j]) {
					marked = false;
					break outer;
				}
			}
		}
		if (marked) {
			sb.append(check);
			return;
		} else {
			sb.append("(");
		}
		n = n / 2;
		recur(sR, sC, n); 
		recur(sR, sC + n, n); 
		recur(sR + n, sC, n);
		recur(sR + n, sC + n, n); 
		sb.append(")");
	}
}
