package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859_백만장자프로젝트 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken());

			}
			long ans = 0;
			for (int i = N - 1; i >= 0; i--) {
	            int j = i-1;
				int buy = 0;
	            while( j >= 0 && arr[i] > arr[j]) {
	               buy += arr[i];
	               buy -= arr[j];
	               j--;
	            }
	            ans += buy;
	            i = j+1;
	         }
			System.out.println("#" + t + " " + ans);
		}
	}
}
