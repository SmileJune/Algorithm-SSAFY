package com.ssafy.yun.pro;

import java.util.Arrays;

public class 예산 {
	public static void main(String[] args) {
		int[] d = { 1, 3, 2, 5, 4 };
		int budget = 9;
		System.out.println(solution(d, budget));
	}

	public static int solution(int[] d, int budget) {
		int answer = 0;

		Arrays.sort(d);
		for (int a : d) {
			if (budget - a >= 0) {
				budget -= a;
				answer++;
			} else {
				break;
			}
		}
		return answer;
	}

}
