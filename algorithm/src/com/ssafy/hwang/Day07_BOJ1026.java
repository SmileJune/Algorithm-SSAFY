package com.ssafy.hwang;
import java.util.Arrays;
import java.util.Scanner;

public class Day07_BOJ1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] a = new int[N];
		int[] b = new int[N];
		int[] transA = a;
		
		Arrays.sort(transA);
		
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			b[i] = sc.nextInt();
		}
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i < N; i++) {
			int index = i;
			for (int j = i+1; j < N; j++) {
				if (b[index] < b[j]) {
					index = j;
				}
				
			}
		}

	}
}
