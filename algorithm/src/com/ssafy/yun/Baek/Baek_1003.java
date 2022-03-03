package com.ssafy.yun;

import java.util.Scanner;

public class Baek_1003 { //시간초과 => DP로 풀어야 함. 배우고 다시 오자.

	static Scanner sc = new Scanner(System.in);
	static int[] arr;
	static int[] fiboArr;

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			solution();
		}
	}

	static void solution() {
		int N = sc.nextInt();
		arr = new int[2];
		fiboArr = new int[41];
		fibo(N);
		System.out.println(arr[0] + " " + arr[1]);
	}

	static int fibo(int N) {
		if (N == 0) {
			arr[0]++;
			return 0;
		}
		if (N == 1) {
			arr[1]++;
			return 1;
		}
		return fibo(N - 1) + fibo(N - 2);

	}

}
