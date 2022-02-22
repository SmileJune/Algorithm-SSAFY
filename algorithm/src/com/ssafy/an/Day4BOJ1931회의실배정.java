package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Day4BOJ1931회의실배정 { // 1931 회의실 배정
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1])
					return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		}); // 정렬에서 계속 시간초과... 백준은 C로 풀어야 하는 문제가 많음.
		int cnt = 0;
		int time = 0;
		for (int i = 0; i < N; i++) {
			if (time <= arr[i][0]) {
				time = arr[i][1];
				cnt++;
			}
		}
//		for (int[] a : arr)
//			System.out.println(Arrays.toString(a));
		System.out.println(cnt);
		br.close();
	}
}
