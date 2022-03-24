package com.ssafy.ehoi;

import java.util.Scanner;

public class Day45_BOJ_B2_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		// a가 1이면 ans는 1;
		int ans = 1;
		
		int i = 0;
		
		int temp = 1;
				
		while(true) {
			if (a <= temp) {
				ans = i + 1;
				break;
			}
			temp += 6 *(i+1);
			i++;
		}
		System.out.println(ans);
		sc.close();
	}
}
