package com.ssafy.an;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day12BOJ2527B직사각형 { // 2527Best 저장용(정현님)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		for (int tc = 1; tc <= 4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[8];
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			sb.append(check(arr)).append("\n");
		}
		System.out.println(sb);

	}

	public static char check(int[] arr) {
		int x;
		int y;
		if (arr[0] <= arr[4]) {
			if (arr[2] < arr[4])
				x = 0;
			else if (arr[2] == arr[4])
				x = 1;
			else
				x = 2;
		} else {
			if (arr[6] == arr[0])
				x = 1;
			else if (arr[6] < arr[0])
				x = 0;
			else
				x = 2;
		}
		if (arr[1] <= arr[5]) {
			if (arr[3] < arr[5])
				y = 0;
			else if (arr[3] == arr[5])
				y = 1;
			else
				y = 2;
		} else {
			if (arr[7] == arr[1])
				y = 1;
			else if (arr[7] < arr[1])
				y = 0;
			else
				y = 2;
		}
		if (x == 2 && y == 2)
			return 'a';
		else if (x == 0 || y == 0)
			return 'd';
		else if (x == 1 && y == 1)
			return 'c';
		else
			return 'b';
	}
}
