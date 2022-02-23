package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day14JO1205조커 { // 1205 아직 푸는 중
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		int max = 0;
		int jo = 0;
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
			if (max < arr[n])
				max = arr[n];
			if (arr[n] == 0)
				jo++;
		}
		int[] cnt = new int[max + 1];
		for (int n = 0; n < N; n++) {
			cnt[arr[n]]++;
		}

		int ans = 0;

		// 예외처리 때 살펴야 할 부분(누락함, 정올이라 테스트 케이스로 확인)
		ans = jo > arr.length - jo ? arr.length : ans;
		// 조커가 조커가 아닌 값보다 클 때 제외처리..
		for (int i = 1; i < max + 1; i++) {
			int ker = jo; // 사용할 때 깍을 값
			int tmp = 0; // 임시로 합칠 값
			for (int j = i; j < max + 1; j++) {
				if (cnt[j] != 0) {
					tmp++;
				} else if (ker != 0) { // 조건 다시 판단할 것
					tmp++;
					ker--;
				} else
					break;
			}
			ans = (ans < tmp) ? tmp : ans;
		}

		System.out.println(ans);
		br.close();
	}
}
