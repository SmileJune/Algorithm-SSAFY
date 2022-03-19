package com.ssafy.ehoi;

import java.util.Scanner;

public class Day23_BOJ_B5_3003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = {1, 1, 2, 2, 2, 8};
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]-sc.nextInt()+" ");
		}
		sc.close();
	}
}
