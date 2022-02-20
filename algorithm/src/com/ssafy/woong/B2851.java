package com.ssafy.woong;

import java.util.Scanner;

public class B2851 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int sum = 0;
		int tmp = 0;
		for(int i = 0; i < 10 ; i++) {
			tmp = sc.nextInt();
			sum += tmp;
			if(sum >= 100) {
				System.out.println(Math.abs(sum-100) > Math.abs(sum-tmp-100) ? sum-tmp : sum);
				return;
			}
			
		}
		System.out.println(sum);
	}
	
}
