package com.ssafy.park;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11650_좌표정렬하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		int N = sc.nextInt();
		int[][] pos = new int[N][2];

		for (int i = 0; i < N; i++) {
			pos[i][0] = sc.nextInt();
			pos[i][1] = sc.nextInt();
		}

		
		Arrays.sort(pos, (o1, o2) -> {
			if (o1[0] == o2[0])
				return Integer.compare(o1[1], o2[1]);
			else
				return Integer.compare(o1[0], o2[0]);
		});

		for (int[] arr : pos) {
			sb.append(String.format("%d %d\n", arr[0], arr[1]));
		}

		System.out.println(sb);
	}

}
