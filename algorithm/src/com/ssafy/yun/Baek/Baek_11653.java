package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_11653 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int K = 2;
		while (N != 1) {
			if (N % K == 0) {
				System.out.println(K);
				N /= K;
				continue;
			}
			K++;
		}
	}
}
