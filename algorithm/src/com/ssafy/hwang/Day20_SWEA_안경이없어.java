package com.ssafy.hwang;

import java.util.Scanner;

public class Day20_SWEA_안경이없어 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		

		String zero = "CEFGHIJKLMNSTUVWXYZ";
		String one = "ADOPQR";
		for (int tc = 1; tc <= T; tc++) {
			String flag = "DIFF";
			String A = sc.next();
			String B = sc.next();
			if (A.length() != B.length()) {
				System.out.printf("#%d %s\n", tc, flag);
				continue;
			}
				

			for (int i = 0; i < A.length(); i++) {
				if (zero.indexOf(A.charAt(i)) > -1) {
					A = A.replace(A.charAt(i), 'C');
				}
				if (one.indexOf(A.charAt(i)) > -1) {
					A = A.replace(A.charAt(i), 'A');
				}
				if (zero.indexOf(B.charAt(i)) > -1) {
					B = B.replace(B.charAt(i), 'C');
				}
				if (one.indexOf(B.charAt(i)) > -1) {
					B = B.replace(B.charAt(i), 'A');
				}
			}
			if(A.equals(B)) {
				flag = "SAME";
			}
			System.out.printf("#%d %s\n", tc, flag);
		}
	}
}
