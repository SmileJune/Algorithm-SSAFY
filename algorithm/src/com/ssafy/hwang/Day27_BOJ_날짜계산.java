package com.ssafy.hwang;

import java.util.Scanner;

public class Day27_BOJ_날짜계산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int E = sc.nextInt();
		if (E == 15)
			E = 0;
		int S = sc.nextInt();
		if (S == 28)
			S = 0;
		int M = sc.nextInt();
		if (M == 19)
			M = 0;

		int i = 1;
		while (true) {
			if (i % 15 == E && i % 28 == S && i % 19 == M) {
				System.out.println(i);
				break;
			}
			i++;
		}
	}

}
