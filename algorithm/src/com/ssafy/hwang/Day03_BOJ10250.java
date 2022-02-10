package com.ssafy.hwang;
/*
 * [BOJ 10250 ACM 호텔 (B3)] 
 * 
 *  기본적인 구현문제 
 *  주어지는 호텔의 높이를 이용해 몫과 나머지를 이용해 방번호를 찾아낸다.
 */
import java.util.Scanner;

public class Day03_BOJ10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int height = sc.nextInt();
			int weight = sc.nextInt();
			int n = sc.nextInt();

			// Y : 호수
			int Y = n / height;
			if (n % height != 0) {
				Y++;
			}
			String YY = "";
			if (Y < 10) {
				YY = "0" + Y;
			} else {
				YY = "" + Y;
			}
			// X : 층수
			int X = n % height;

			if (n % height == 0) {
				X = height;
			}

			System.out.printf("%d%s%n", X, YY);
		}
	}
}
