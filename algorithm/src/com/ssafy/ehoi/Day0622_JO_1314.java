package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0622_JO_1314 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		char ch = 'A';
		char[][] arr = new char[n][n];
		
		for (int j = 0; j < n; j++) {
			if (j % 2 == 0) {
				for (int i = 0; i < n; i++) {
					arr[i][j] = ch++;
					if (ch == (char)('Z' + 1)) {
						ch = 'A';
					}
				}
			} else {
				for (int i = n - 1; i >= 0; i--) {
					arr[i][j] = ch++;
					if (ch == (char) ('Z' + 1)) {
						ch = 'A';
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
		sc.close();
	}

}
