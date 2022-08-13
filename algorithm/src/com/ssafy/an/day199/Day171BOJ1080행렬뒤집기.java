package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day171BOJ1080행렬뒤집기 { // 1080
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[][] A = new boolean[N][M];
		boolean[][] B = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if(str.charAt(j)=='1') A[i][j] = true;
			}
		}
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				if(str.charAt(j)=='1') B[i][j] = true;
			}
		}
		
		if(N < 3 || M < 3) {
			if(isSame(A, B)) System.out.println(0);
			else System.out.println(-1);
			System.exit(0);
		}
		
		int ans = 0;
		
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if(A[i][j] != B[i][j]) {
					reverseMatrix(A, i, j);
					ans++;
				}
			}
		}
		
		if(isSame(A, B)) System.out.println(ans);
		else System.out.println(-1);

	}

	private static void reverseMatrix(boolean[][] a, int x, int y) {
		for (int i = x; i < x+3; i++) {
			for (int j = y; j < y+3; j++) {
				a[i][j] = !a[i][j];
			}			
		}		
	}

	private static boolean isSame(boolean[][] a, boolean[][] b) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(a[i][j] != b[i][j]) return false;
			}
		}
		return true;
	}

}
