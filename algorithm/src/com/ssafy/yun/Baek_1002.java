package com.ssafy.yun;

import java.util.Scanner;

public class Baek_1002 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.println(solution());
		}
	}

	static int solution() {
		double[] spot1 = { sc.nextDouble(), sc.nextDouble() };
		double r1 = sc.nextDouble();
		double[] spot2 = { sc.nextDouble(), sc.nextDouble() };
		double r2 = sc.nextDouble();
		double distance = Math.sqrt(Math.pow(spot1[0] - spot2[0], 2) + Math.pow(spot1[1] - spot2[1], 2));

		// 다른점
		if (spot1[0] != spot2[0] || spot1[1] != spot2[1]) {
			// 교점 x
			if (distance > r1 + r2) {
				return 0;
			}
			// 한점에서 접할 때 내접
			if (distance == r1 + r2) {
				return 1;
			}
			// 외접
			if (distance + Math.min(r1, r2) == Math.max(r1, r2)) {
				return 1;
			}
			// 하나의 원이 다른 하나의 원에 포함되는 경우
			if (distance + Math.min(r1, r2) < Math.max(r1, r2)) {
				return 0;
			}
			// 두점에서 만날 때
			return 2;
		}

		// 같은점
		// 완전히 겹칠 때
		if (r1 == r2) {
			return -1;
		}
		// 반지름이 다를때
		return 0;
	}

}
