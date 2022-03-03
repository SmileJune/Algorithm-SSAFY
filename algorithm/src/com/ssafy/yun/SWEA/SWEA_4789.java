package com.ssafy.yun.SWEA;

import java.util.Scanner;

public class SWEA_4789 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	static int solution() {
		String str = sc.next();
		int[] arr = new int[str.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str.charAt(i) + "");
		}

		int sum = 0;
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			if (sum < i) {
				int cnt = i - sum;
				answer += cnt;
				sum += cnt;
			}
			sum += arr[i];
		}

		return answer;
	}

}
