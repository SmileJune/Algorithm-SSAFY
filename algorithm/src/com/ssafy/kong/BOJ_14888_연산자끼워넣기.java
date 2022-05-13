package com.ssafy.BOJ_SB;

import java.util.*;

public class BOJ_14888_연산자끼워넣기 {
	static int n; // n개의 숫자 입력
	static int check[], cal[];
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	static void dfs(int num, int idx) {

		if (idx == n) {
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
			return;
		}

		int result = 0;
		for (int j = 0; j < 4; j++) {
			if (cal[j] != 0) {
				cal[j]--;

				switch (j) {
				case 0:
					result = num + check[idx];
					break;
				case 1:
					result = num - check[idx];
					break;
				case 2:
					result = num * check[idx];
					break;
				case 3:
					if (num < 0 && check[idx] > 0) {
						num *= -1;
						result = num / check[idx];
						result *= -1;
					} else {
						result = num / check[idx];

						break;
					}

				}
				dfs(result, idx + 1);
				cal[j]++;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		check = new int[n];
		cal = new int[4];

		for (int i = 0; i < n; i++) {
			check[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			cal[i] = sc.nextInt();
		}

		dfs(check[0], 1); // DFS 호출
		System.out.println(max);
		System.out.println(min);
	}

}