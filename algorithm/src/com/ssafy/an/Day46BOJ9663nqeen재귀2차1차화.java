package com.ssafy.an;

import java.util.Scanner;

public class Day46BOJ9663nqeen재귀2차1차화 { // 9663 N-Queen 
	static int N;
	static int[] arr;
	static int ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		nQueen(0);
		System.out.println(ans);
		sc.close();
	}

	public static void nQueen(int depth) {
		if (depth == N) {
			ans++;
			return;
		}
		for (int i = 0; i < N; i++) {
			arr[depth] = i;
			if (isPossile(depth))
				nQueen(depth + 1);
		}
	}

	private static boolean isPossile(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i])
				return false;
			else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i]))
				return false;
		}
		return true;
	} // 2차원으로 풀었는데, 구선생님께서 1차원으로 arr[col] = row가 되는 1차원으로 재귀..
} // 모든 좌표를 방문해서 가능, 불가능 여부를 찾는 방법에 활용가능
