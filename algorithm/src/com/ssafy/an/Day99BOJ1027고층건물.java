package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day99BOJ1027고층건물 {
	static final int INF = 1_000_000_001;
	static int N, ans, tmp;
	static double l; // 기울기 tmp
	static double[] arr; // 1_000_000_000, 접함을 구하려면

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new double[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Double.parseDouble(st.nextToken());
		for (int i = 0; i < N; i++)
			ans = Math.max(ans, bfr(i) + aft(i));
		System.out.println(ans);
		br.close();
	}

	private static int bfr(int idx) {
		tmp = 0;
		l = INF; // i기준 이전 빌딩이 더 낮으면 양의 기울기
		for (int i = idx - 1; i >= 0; i--) {
			if ((lean(i, idx)) >= l)
				continue;
			l = lean(i, idx);
			tmp++;
		}
		return tmp;
	}

	private static int aft(int idx) {
		tmp = 0;
		l = -INF; // i기준 이후 빌딩이 더 낮으면 음의 기울기
		for (int i = idx + 1; i < N; i++) {
			if (lean(i, idx) <= l)
				continue;
			l = lean(i, idx);
			tmp++;
		}
		return tmp;
	}

	private static double lean(int a, int b) {
		return (arr[a] - arr[b]) / (double) (a - b);
	}
}
