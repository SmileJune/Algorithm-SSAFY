package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_4948 {

	static Scanner sc = new Scanner(System.in);
	static boolean[] isNotPrime;

	public static void main(String[] args) {
		// 소수 다 구해놓고
		isNotPrime = new boolean[123456*2+1];
		isNotPrime[0] = isNotPrime[1] = true;
		for (int i = 2; i * i <= isNotPrime.length; i++) {
			if (isNotPrime[i] == true) {
				continue;
			}
			for (int j = i * i; j < isNotPrime.length; j += i) {
				isNotPrime[j] = true;
			}
		}

		// 갯수만체크
		while (sc.hasNext()) {
			try {
				System.out.println(check(sc.nextInt()));
			} catch (Exception e) {
				return;
			}
		}

	}

	static int check(int n) throws Exception {
		if (n == 0) {
			throw new Exception();
		}
		int cnt = 0;
		for (int i = n + 1; i <= 2 * n; i++) {
			if (!isNotPrime[i]) {
				cnt++;
			}
		}
		return cnt;
	}

}
