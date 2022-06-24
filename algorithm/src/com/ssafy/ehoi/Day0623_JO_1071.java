package com.ssafy.ehoi;

import java.util.Scanner;

public class Day0623_JO_1071 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int m = sc.nextInt();
		
		int yak_sum = 0;
		int bae_sum = 0;
		for (int i = 0; i < n; i++) {
			if (m % arr[i] == 0) {
				// 약수라면
				yak_sum += arr[i];
			}
			if (arr[i] % m == 0) {
				// 배수라면
				bae_sum += arr[i];
			}
		}
		
		System.out.println(yak_sum);
		System.out.println(bae_sum);
		sc.close();
	}
}
