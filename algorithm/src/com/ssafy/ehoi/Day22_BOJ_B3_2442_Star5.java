package com.ssafy.ehoi;

import java.util.Scanner;

public class Day22_BOJ_B3_2442_Star5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			for (int j = n-i; j >= 1; j--) {
				System.out.print(" ");
			}
			for (int j = 2*i-1; j >=1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

		sc.close();
	}
}
