package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day188BOJ10810구간합 { // 1081 합 구간합
	static long L, U;
	static long[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		cnt = new long[10];
		long delta = 1;
		while (L <= U) {
			for (; L % 10 != 0 && L <= U; L++) {
				parse(L, delta);
			}

			for (; U % 10 != 9 && L <= U; U--) {
				parse(U, delta);
			}

			if (L > U)
				break;

			L /= 10;
			U /= 10;
			long rowCnt = U - L + 1;
			for (int i = 0; i < 10; i++) {
				cnt[i] += delta * rowCnt;
			}
			delta *= 10;
		}
		long ans = 0L;
		for (int i = 0; i < 10; i++) {
			ans += i * cnt[i];
		}
		System.out.println(ans);
		br.close();
	}

	static void parse(long x, long delta) {
		while (x > 0) {
			cnt[(int) x % 10] += delta;
			x /= 10;
		}
	}
}
