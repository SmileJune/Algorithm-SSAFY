package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

public class Day0602_ICOTE_GREEDY_Q02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		
		int ans = 0;
		for (int i = 0; i < str.length(); i++) {
			int num = str.charAt(i) - 48;
			if(ans == 0 || ans == 1 || num == 0 || num == 1) {
				ans += num;
			} else {
				ans *= num;
			}
		}
		
		System.out.println(ans);
		
		
		sc.close();
	}
}