package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_5356 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %s%n", tc, solution());
		}
	}

	static String solution() {
		boolean[] visited = new boolean[5];
		String[] arr = new String[5];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}

		int maxLength = 0;
		for (int i = 0; i < arr.length; i++) {
			maxLength = Math.max(maxLength, arr[i].length());
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (visited[j] == true) {
					continue;
				}

				sb.append(arr[j].charAt(i));

				if (i == arr[j].length() - 1) {
					visited[j] = true;
				}
			}
		}
		return sb.toString();
	}
}
