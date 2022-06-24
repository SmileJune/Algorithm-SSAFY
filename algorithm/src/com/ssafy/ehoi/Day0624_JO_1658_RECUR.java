package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0624_JO_1658_RECUR {
	static int GCD, LCM;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int small = sc.nextInt();
		int big = sc.nextInt();
		
		if (small > big) {
			int swap = small;
			small = big;
			big = swap;
		}
		
		
		System.out.println(GCD = get_GCD(big, small));
		System.out.println(LCM = small * big / GCD);

		sc.close();
	}

	private static int get_GCD(int x, int y) {
		if (y == 0) {
			return x;
		}
		
		return get_GCD(y, x % y);
	}
}
