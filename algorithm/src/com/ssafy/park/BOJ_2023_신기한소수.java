package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023_신기한소수 {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		recur(0, N);
		System.out.println(sb);
	}

	public static void recur(int output, int n) {
		if (n == 0) {
			if (isPrime(output))
				sb.append(output).append("\n");
			return;
		}
		for (int i = 0; i < 10; i++) {
			int next = output * 10 + i;
			if (isPrime(next))
				recur(next, n - 1);
		}
	}

	public static boolean isPrime(int num) {
		if (num < 2)
			return false;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
