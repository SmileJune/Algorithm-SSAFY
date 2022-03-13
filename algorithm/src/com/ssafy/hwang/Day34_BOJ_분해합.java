package com.ssafy.hwang;

import java.util.Scanner;

public class Day34_BOJ_분해합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int m =N;
		int ans=0;
		while (m>0) {
			m--;
			int tmp = m;
			int sum = m;
			while (tmp > 0) {
				sum += tmp % 10;
				tmp /= 10;
			}
			if (sum == N) {
				ans= m;
			}
		}
		System.out.println(ans);
		
	}

}
