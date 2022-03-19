package com.ssafy.yun.Baek;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baek_2581 {

	static Scanner sc = new Scanner(System.in);
	static boolean[] notPrime;

	public static void main(String[] args) {
		int M = sc.nextInt();
		int N = sc.nextInt();

		notPrime = new boolean[N + 1];
		notPrime[0] = true;
		notPrime[1] = true;

		for (int i = 2; i <= 8; i++) {
			// 체크 됐을 때 패스
			if (notPrime[i] == true) {
				continue;
			}

			// 체크 안됐을 때 그 이후 배수값을 다 체크
			for (int j = i * i; j <= N; j += i) {
				notPrime[j] = true;
			}
		}

		int sum = 0;
		List<Integer> list = new ArrayList<>();
		for (int i = M; i <= N; i++) {
			if (notPrime[i] == false) {
				list.add(i);
				sum += i;
			}
		}

		Collections.sort(list);

		if (list.isEmpty()) {
			System.out.println(-1);
			return;
		}

		System.out.println(sum);
		System.out.println(list.get(0));

	}

}
