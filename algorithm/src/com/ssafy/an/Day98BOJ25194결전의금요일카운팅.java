package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day98BOJ25194결전의금요일카운팅 { // 25194 결전의 금요일 카운팅
	static int N;
	static int[] cnt;
	static boolean ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = new int[7];
		ans = false;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0, n = 0; i < N; i++)
			if ((n = Integer.parseInt(st.nextToken()) % 7) != 0)
				cnt[n]++;

		if (cnt[4] != 0)
			ans = true;
		else
			dfs(0);

		System.out.println(ans ? "YES" : "NO");
		br.close();
	}

	private static void dfs(int sum) {
		if (sum > 142 || ans)
			return;
		if (sum % 7 == 4) {
			ans = true;
			return;
		}
		for (int i = 1; i < 7; i++) {
			if (cnt[i] != 0) {
				cnt[i]--;
				dfs(sum + i);
				cnt[i]++;
			}
		}
	}
}
