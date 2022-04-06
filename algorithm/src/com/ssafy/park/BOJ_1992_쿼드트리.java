package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	public static class point {
		int r;
		int c;
		public point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[][] map;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) -'0';
			}
		}
		point left = new point(0,0);
		point right = new point(N-1,N-1);
		divide(left, right);
		System.out.println(sb);
	}
	public static void divide(point left, point right) {
		int result = check(left,right);
		if (result != -1) {
			sb.append(result);
			return;
		}
		else {
			sb.append('(');
			int midr = (left.r + right.r)/2;
			int midc = (left.c + right.c)/2;
			divide(left, new point(midr, midc));
			divide(new point(left.r, midc+1), new point(midr,right.c));
			divide(new point(midr+1, left.c), new point(right.r, midc));
			divide(new point(midr+1, midc+1), right);
			sb.append(')');
		}
	}
	public static int check(point left, point right) {
		int num = map[left.r][left.c];
		for (int i = left.r; i <= right.r; i++) {
			for (int j = left.c; j <= right.c; j++) {
				if (map[i][j] != num) return -1;
			}
		}
		return num;
	}
}
