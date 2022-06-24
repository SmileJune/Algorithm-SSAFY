package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0622_JO_1304 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int num = 1;
		
		int[][] arr = new int[n][n];
		
		for (int j = 0; j < n ; j++) {
			for (int i = 0; i < n; i++) {
				arr[i][j] = num++;
			}
		}
		
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}

}
