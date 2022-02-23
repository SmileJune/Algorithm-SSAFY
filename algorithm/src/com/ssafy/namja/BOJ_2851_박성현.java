package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_2851_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] mushroom = new int[10];
		for (int i = 0; i < 10; i++)
			mushroom[i] = sc.nextInt();
		
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			if (100 - sum >= Math.abs(100 - (sum + mushroom[i]))) 
				sum += mushroom[i];
			else break;
		}
		
		System.out.println(sum);
	}
}