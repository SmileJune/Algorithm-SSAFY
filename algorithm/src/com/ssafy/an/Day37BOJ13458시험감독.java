package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day37BOJ13458시험감독 { // 13458 시험감독
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long ans = 0;

		for (int i = 0; i < N; i++) {
			ans++;
			if (arr[i] > B) {
				arr[i] -= B;
				ans += (arr[i] % C == 0) ? arr[i] / C : arr[i] / C + 1;				
			}
		}

		System.out.println(ans);
		br.close();
	}
}
