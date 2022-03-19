package com.ssafy.hwang;

import java.util.Scanner;

public class Day09_BOJ2525_오븐시계 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int min = sc.nextInt() + sc.nextInt();
		
		if(min>60) {
			hour = hour+min/60;
			min = min-60*(min/60);
		}
		if(hour>=24) {
			hour= hour-24*(hour/24);
		}
		
		System.out.printf("%d %d", hour,min);
		
		
				
	}
}
