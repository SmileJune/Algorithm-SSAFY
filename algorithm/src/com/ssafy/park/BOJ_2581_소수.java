package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2581_소수 {
	public static boolean bo[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		bo = new boolean[B + 1];
		get_prime();
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = A; i <= B; i++) {
			if (bo[i] == false) {
				sum += i;
				if (min == Integer.MAX_VALUE) {
					min = i;
				}
			}
		}
		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
	public static void get_prime() {
		bo[0] = true;
		bo[1] = true;
		for (int i = 2; i <= Math.sqrt(bo.length); i++) {
			if (bo[i])
				continue;
			for (int j = i * i; j < bo.length; j += i) {
				bo[j] = true;
			}
		}
	}
}