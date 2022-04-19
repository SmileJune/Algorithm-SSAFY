package com.ssafy.ehoi;

import java.math.BigDecimal;
import java.util.Scanner;

public class Day71_BOJ_G5_1405 {
	static int N, r, c;
	static double ans;
	static double[] percent = new double[4];
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static boolean[][] visit = new boolean[40][40];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = 0;
		for (int i = 0; i < 4; i++)
			percent[i] = sc.nextInt() * 0.01;

		// 로봇이 있는 좌표가
		dfs(20, 20, 0, 1);
		
		BigDecimal tmp = new BigDecimal(ans);

		System.out.print(tmp);

		sc.close();
	}



	// 단순할 확률 구하는 중
	private static void dfs(int r, int c, int cnt, double per) {
		// 다 뽑았다는 건 한번도 중복없이 왔다는 것
		// 단순하다는 것 그럼 그 확률을 ans에 더해놓자
		if (cnt == N) {
			ans += per;
			return;
		}

		visit[r][c] = true;

		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			// 범위 체크는 넉넉하게 잡았으니까 할 필요 없을 것 같고
			if(visit[nr][nc]) continue; // 이미 방문했으면 컨티뉴
			visit[nr][nc] = true;
			dfs(nr, nc, cnt + 1, per * percent[d]);
			visit[nr][nc] = false;
		}
		

	}
}
