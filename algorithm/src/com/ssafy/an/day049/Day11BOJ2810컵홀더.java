package com.ssafy.an.day049;

import java.util.Scanner;

public class Day11BOJ2810컵홀더 {// 2810
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		String s = sc.nextLine();
		int cnt = 1;
		for (int i = 0; i < T; i++) {
			char c = s.charAt(i);
			if (c == 'S')
				cnt++;
			else if (c == 'L') {
				cnt++;
				i++;
			}
		} // 컵의 최대 갯수는 사람 수를 넘지 않는다!!!!!
		System.out.println(cnt <= T ? cnt : T);
		sc.close();
	}
}
