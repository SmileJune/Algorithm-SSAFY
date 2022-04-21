package com.ssafy.hwang;

import java.util.Scanner;

public class Day73_BOJ_분산처리 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int a, b, c, result;
		for (int i = 0; i < t; i++) {
			a = s.nextInt();
			b = s.nextInt();
			c = 0;
			result = 1;
			if (a % 10 == 0 || a % 10 == 1 || a % 10 == 5 || a % 10 == 6) {
				result = a % 10;
			} else if (a % 10 == 4 || a % 10 == 9) {
				c = b % 2;
				if (c == 0)
					c = 2;
			} else {
				c = b % 4;
				if (c == 0)
					c = 4;
			}
			for (int j = 0; j < c; j++)
				result = (result * a) % 10;
			if (result == 0)
				result = 10;
			System.out.println(result);
		}
	}
}
