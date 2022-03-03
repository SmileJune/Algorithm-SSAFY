package com.ssafy.yun;

import java.util.Scanner;

public class Baek_10953 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.println(solution());
		}
	}

	static int solution() {
		String[] arr = sc.next().split(",");
		return Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
	}

}
