package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1859_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= n; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int lastprice = arr[N - 1];
			int cnt = 0;
			int beforecnt = 0;
			int sum = 0;
			int ans = 0;
			int beforeprice = 0;
			for (int i = 0; i < N; i++) {
				if (arr[i] < lastprice) {
					sum += arr[i];
					cnt++;
				} else if (arr[i] > lastprice && beforecnt > 0) {
					if (arr[i] > beforeprice) {
						ans += (arr[i] - beforeprice) * (beforecnt + 1);
						beforeprice = arr[i];
						beforecnt++;
					}
				} else {
					ans += arr[i] * cnt - sum;
					sum = 0;
					beforeprice = arr[i];
					beforecnt += cnt;
					cnt = 0;
				}
			}
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb);
	}
}
