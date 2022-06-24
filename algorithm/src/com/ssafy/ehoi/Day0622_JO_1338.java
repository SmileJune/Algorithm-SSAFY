package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0622_JO_1338 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		char[][] arr = new char[n+1][n+1];
		char ch = 'A';

		for (int i = 1; i <= n; i++) {
			for (int j = i, k = n; j <= n; j++, k--) {
				arr[j][k] = ch++;
				if(ch > 'Z') {
					ch = 'A';
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if('A' <= ch && ch <= 'Z') {
					System.out.print(arr[i][j] + " ");
				} else {
					System.out.print("");
				}
			}
			System.out.println();
		}

		sc.close();
	}
}
