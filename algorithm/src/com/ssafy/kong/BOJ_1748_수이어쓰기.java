package com.ssafy.BOJ_SB;

import java.util.Scanner;

public class BOJ_1748_수이어쓰기 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
//		str = "";
//		for (int i = 1; i <= N; ++i) {
//			str += i+"";
//		}
//		System.out.println(str.length());
		// 이거는 메모리초과남... ? ㅜ_ㅜ
//		int cnt = 0;
//		int add = 1;
//		for (int i = 1; i <= N; ++i) {
//			cnt++;
//			if (cnt == (int) Math.pow(10, add)) {
//				add++;
//			}
//			ans += add;
//		} 
		int cnt = 1;
		int ans = 0;
		int lenght = 10;
		for (int i = 1; i <= N; i++) {
			if (i == lenght) {
				cnt++;
				lenght = lenght * 10;
			}
			ans = ans + cnt;
		}
		System.out.println(ans);
	}
}
