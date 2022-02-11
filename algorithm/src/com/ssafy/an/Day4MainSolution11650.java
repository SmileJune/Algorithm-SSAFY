package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day4MainSolution11650 { // 11650번 좌표 정렬
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
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
		
/*		// 아직 우리가 배운 걸로는 시간초과가 뜨는 자바 비친화적인 문제.
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j][0] > arr[j + 1][0]) {
					int[] temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				} else if (arr[j][0] == arr[j + 1][0]) {
					if (arr[j][1] > arr[j + 1][1]) {
						int[] temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}
		}
*/
		for (int n = 0; n < N; n++) {
			System.out.println(arr[n][0] + " " + arr[n][1]);
		}
	}
}
