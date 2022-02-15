package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day5MainSolution11651 { // 11651번 좌표 정렬
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int num = 0; num < N; num++) {
			st = new StringTokenizer(br.readLine());
			arr[num][0] = Integer.parseInt(st.nextToken());
			arr[num][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (e1, e2) -> {
			if(e1[1] == e2[1]) {
				return e1[0] - e2[0];
			} else {
				return e1[1] - e2[1];
			}
		});
		
		for (int n = 0; n < N; n++) {
			System.out.println(arr[n][0] + " " + arr[n][1]);
		}
	}
}
