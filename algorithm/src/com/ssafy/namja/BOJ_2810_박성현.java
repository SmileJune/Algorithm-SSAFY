package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_2810_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		String seat = sc.nextLine();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (seat.charAt(i) == 'L')
				i++;
			cnt++;
		}
		cnt++;
		if (cnt > N)
			cnt = N;
		System.out.println(cnt);
	}
}
