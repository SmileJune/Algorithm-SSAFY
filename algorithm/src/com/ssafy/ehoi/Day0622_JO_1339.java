package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Day0622_JO_1339 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (1 <= n && n <=100 & n % 2 != 0) {
				break;
			} else {
				System.out.println("INPUT ERROR");
			}
		}
		
		char[][] arr = new char[n][n];
		char ch = 'A';
		
		for (int j = n/2; j >= 0; j--) {
			for (int i = j; i < n - j; i++) {
				arr[i][j] = ch++;
				if (ch > 'Z') {
					ch = 'A';
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
