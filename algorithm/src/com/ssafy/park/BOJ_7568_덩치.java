package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7568_덩치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			int idx = 0;
			int cnt = 1;
			while (idx < N) {
				if (idx == i) {
					idx++;
				} else {
					if (arr[i][0] < arr[idx][0] && arr[i][1] < arr[idx][1]) {
						cnt++;
					}
					idx++;
				}
			}
			sb.append(cnt + " ");
		}
		System.out.println(sb);
	}
}
