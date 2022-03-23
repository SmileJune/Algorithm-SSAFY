package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_2446_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		
		for (int i = 0; i < 2 * N - 1; i++) {
			if (i < N) {
				for (int j = 0; j < i; j++) 
					System.out.print(" ");
				
				for (int j = 0; j < 2 * (N - i) - 1; j++)
					System.out.print("*");
			}
			else {
				for (int j = 0; j < 2 * (N - 1) - i; j++)
					System.out.print(" ");
				
				for (int j = 0; j < 1 + 2 * (i - N + 1); j++)
					System.out.print("*");
			}
			System.out.println();
		}
	}
}