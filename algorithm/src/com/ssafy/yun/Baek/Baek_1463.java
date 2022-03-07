package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1463 { //DP는 아직 안배웠습니다ㅠㅠ

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		int cnt = 0;
		while (true) {
			if (N == 1) {
				break;
			}
			if (N % 3 == 0) {
				N /= 3;
				cnt++;
				continue;
			}
			if (N % 2 == 0) {
				N /= 2;
				cnt++;
				continue;
			}
			N -= 1;
			cnt++;
		}
		System.out.println(cnt);
	}

}
