package com.ssafy.SWEA_SW모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2117_홈방범서비스 {
	static int N, M, ans, K, money, cnt;
	// ans : 정답, money: 운영 비용, cnt: 범위내에있는 집의 수
	static int[][] map;
	static boolean[][] isScope;
//	static int[] dr = { -1, 0, 1, 0 };
//	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 도시의 크기
			M = Integer.parseInt(st.nextToken()); // 하나의 집이 지불할 수 있는 비용
			map = new int[N][N];
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			select();
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void select() {
		int end = N % 2 == 0 ? N + 1 : N + 2;
		for (int i = 1; i < N * 2; ++i) {
			K = i;
			doService();
		}
	}

	private static void doService() {
		// 운영 비용
		money = K * K + (K - 1) * (K - 1);
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				isScope = new boolean[N][N];
//				int sum = sumScope(i, j);
//				System.out.println("money : " + money + ", sum : " + sum);
				ans = Math.max(sumScope(i, j), ans); // 범위 안에 있는 것들 다 더해.
			}
		}
	}

	private static int sumScope(int r, int c) {
		cnt = 0;
		int sum = 0;
		for (int i = 0; i < K; ++i) {
			for (int j = 0; j < K - i; ++j) {
				if (isRange(r + i, c + j)) {
					isScope[r + i][c + j] = true;
				}
			}
		}
		for (int i = 0; i < K; ++i) {
			for (int j = 0; j > -(K - i); --j) {
				if (isRange(r + i, c + j)) {
					isScope[r + i][c + j] = true;
				}
			}
		}
		for (int i = 0; i > -K; --i) {
			for (int j = 0; j > -(K + i); --j) {
				if (isRange(r + i, c + j)) {
					isScope[r + i][c + j] = true;
				}
			}
		}
		for (int i = 0; i > -K; --i) {
			for (int j = 0; j < (K + i); ++j) {
				if (isRange(r + i, c + j)) {
					isScope[r + i][c + j] = true;
				}
			}
		}
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (isScope[i][j]) {
					if (map[i][j] == 1) {
						cnt++;
						sum += M * map[i][j];
					}
				}
			}
		}

//		System.out.println("K 범위 : " + K);
//		for(int i = 0; i < N; ++i) {
//			for(int j = 0; j < N; ++j) {
//				if(isScope[i][j]) {
//					System.out.print(1 + " ");
//				}else {
//					System.out.print(0 + " ");
//				}
//			}
//			System.out.println();
//		}

		if (sum - money >= 0) {
			return cnt;
		}
		return 0;

	}

	private static boolean isRange(int i, int j) {
		return i >= 0 && j >= 0 && i < N && j < N;
	}

}
