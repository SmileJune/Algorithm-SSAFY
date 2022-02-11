package com.ssafy.an;

import java.util.Scanner;

public class Day2MainSolution2839 {
	public static void main(String[] args) {// 2839 설탕배달, 브론즈 1
		Scanner sc = new Scanner(System.in); // 완전탐색으로 실행 
		int bag5 = 5;
		int bag3 = 3;
		int sugar = Integer.parseInt(sc.nextLine());

		int minCnt = Integer.MAX_VALUE;
		// 완전탐색이기 때문에 '<='까지 해야함. 인덱스랑 헷갈리지 말기. 
		for (int i = 0; i <= (int) Math.ceil((double) sugar / bag5); i++) {// 18이라면 3까지 가능.
			for (int j = 0; j <= (int) Math.ceil((double) sugar / bag3); j++) { // 18이라면 6
				if (sugar - (bag5 * i + bag3 * j) == 0) {
					if (minCnt > i + j) {
						minCnt = i + j;
					}
				}
			}
		}
		if (minCnt == Integer.MAX_VALUE)
			minCnt = -1;
		System.out.println(minCnt);
		sc.close();
	}
}
