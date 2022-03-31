package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_9934 {

	static Scanner sc = new Scanner(System.in);
	static int[] arr;
	static int k;

	public static void main(String[] args) {
		k = sc.nextInt();
		arr = new int[(int) Math.pow(2, k)];
		inorder(1);
		for (int i = 1; i <= k; i++) {
			for (int j = (int) Math.pow(2, i - 1); j < (int) Math.pow(2, i); j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}

	}

	static void inorder(int idx) {
		if (idx * 2 <= (int) Math.pow(2, k) - 1) {
			inorder(idx * 2);
		}
		arr[idx] = sc.nextInt();
		if (idx * 2 + 1 <= (int) Math.pow(2, k) - 1) {
			inorder(idx * 2 + 1);
		}
	}

}
