package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Day0620_BOJ_S5_11650 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		Arrays.sort(arr, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				// x좌표 순으로 오름차순
//				// x좌표가 같다면 y좌표를 기준으로 오름차순
//				if(o1[0] == o2[0]) {
//					return o1[1] - o2[1];
//				} else {
//					return o1[1] - o2[1];
//				}
//			}
//		});
		
		Arrays.sort(arr, (o1, o2) -> {
			if(o1[0] == o2[0]) {
				return o1[1] - o2[1];
			} else {
				return o1[0] - o2[0];
			}
		});
		
		for (int i = 0; i < N; i++) {
				System.out.printf("%d %d\n", arr[i][0], arr[i][1]);
		}
		
		
	}
}
