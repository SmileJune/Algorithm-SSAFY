package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Day40_BOJ_S2_1931 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 회의 수 입력받기
		int N = Integer.parseInt(br.readLine());
		// 회의의 시작과 끝 배열 만들어서
		int[][] arr = new int[N][2];
		// 입력받기
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		System.out.println(Arrays.deepToString(arr));

		// 종료가 빠른 순으로
		// 종료가 빠르다면 시작이 빠른 순으로 정렬하기
		// 2차원 배열 정렬하는 법
		// int[]을 비교할 거다
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 1번째 열이 같다면 0번째 열을 작은 애부터
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
					// 다르다면 1번째 열이 작은애부터
				} else
					return o1[1] - o2[1];
			}
		});
//		System.out.println(Arrays.deepToString(arr));

		// 회의는 무조건 한번은 가능하다
		int cnt = 1; 
		// 첫번째 회의가 끝나는 시간
		int prevEndTime = arr[0][1];
		
		for (int i = 1; i < N; i++) {
			// 이전 회의가 끝난 시간보다 i번째 회의의 시작 시간이 같거나 크다면 회의 진행 가능
			if(prevEndTime <= arr[i][0]) {
				cnt++;
				// 이번 회의의 끝나는 시간이 다음 회의의 시작 시간과 비교될 수 있게
				prevEndTime = arr[i][1];
			}
		}
		
		
		System.out.println(cnt);

	}
}
