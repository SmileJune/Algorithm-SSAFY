package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0701_JO_2604 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int ans = 10;

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) { // 현재 그릇의 모양이 직전 그릇 모양과 같다면
				ans += 5; // 높이는 5만큼 증가하고
			} else { // 다르게 쌓았다면
				ans += 10; // 높이는 10만큼 증가한다
			}
		}

		System.out.println(ans);
		sc.close();
	}
}
