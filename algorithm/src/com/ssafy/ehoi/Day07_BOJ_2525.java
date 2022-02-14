package com.ssafy.ehoi;

import java.util.Scanner;

public class Day07_BOJ_2525 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int min = sc.nextInt() +sc.nextInt();
		
		
		while (min > 59) {
			hour++;
			min -= 60;
		}
		
		while (hour > 23) {
			hour -= 24;
		}
		
		System.out.printf("%d %d", hour, min);
		
		
		
		
		sc.close();
	}
}
