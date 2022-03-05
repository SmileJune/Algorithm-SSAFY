package com.ssafy.woong;

import java.util.Arrays;
import java.util.Scanner;

public class B2775 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			System.out.printf("%d\n",solution());
		}
	}
	
	static int solution() {
		int k = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		
		for(int i = 0 ; i < k; i++) {
			for(int j = 2; j <= n; j++) {
				arr[j] += arr[j-1];
			}
		}
		return arr[n];
	}
}
