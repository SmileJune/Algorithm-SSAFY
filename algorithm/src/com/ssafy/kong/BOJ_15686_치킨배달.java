package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class xy {
	int x;
	int y;

	xy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_15686_치킨배달 {
	static int N, M;
	static boolean[] flag;
	static ArrayList<xy> home;
	static ArrayList<xy> chicken;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][N];
		chicken = new ArrayList<>();
		home = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					chicken.add(new xy(i, j));
				} else if (map[i][j] == 1) {
					home.add(new xy(i, j));
				}
			}
		}

		ans = Integer.MAX_VALUE;
		flag = new boolean[chicken.size()];

		recur(0, 0);

		System.out.println(ans);
	}

	static void recur(int idx, int cnt) {
		if (cnt == M) {
			int sum = 0;
			for (int i = 0; i < home.size(); ++i) {
				int minDis = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); ++j) {
					if (flag[j]) {
						int dis = Math.abs(home.get(i).x - chicken.get(j).x)
								+ Math.abs(home.get(i).y - chicken.get(j).y);
						minDis = Math.min(minDis, dis);
					}
				}
				sum += minDis;
			}
			ans = Math.min(ans, sum);
			return;
		}

		for (int i = idx; i < chicken.size(); ++i) {
			if (!flag[i]) {
				flag[i] = true;
				recur(i + 1, cnt + 1);
			}
			flag[i] = false;
		}
	}

}