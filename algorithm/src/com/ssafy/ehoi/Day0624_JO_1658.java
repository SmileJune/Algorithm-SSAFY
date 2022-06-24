package com.ssafy.ehoi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day0624_JO_1658 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int small = sc.nextInt();
		int big = sc.nextInt();
		
		int GCD = 0; // 최대 공약수
		int LCM = 0; // 최소 공배수

		// 이거 유클리드 호제법 썼었는데 기억이 안나니까 일단..
		if (small > big) {
			int swap = small;
			small = big;
			big = swap;
		}

		// 일단 작은 수의 약수를 구하자
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i * i <= small; i++) {
			if (small % i == 0) {
				list.add(i);
				if (small / i != i) {
					list.add(small / i);
				}
			}
		}
		
		Collections.sort(list); // 오름차순으로 정렬
		
		// 이게 공약수를 구하자
		for (int i = list.size() - 1; i >= 0; i--) {
			if (big % list.get(i) == 0) { // 큰 수로도 나누어지면
				// 바로 너다
				GCD = list.get(i);
				break;
			}
		}

		LCM = small * big / GCD;
		
		System.out.println(GCD);
		System.out.println(LCM);
		sc.close();
	}
}
