package com.ssafy.yun.Baek;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_1991 {

	// 문자를 숫자로 아스키 코드로 표현 해봐야겠다.
	// 'A' 65 -> 1 (-64)
	static Scanner sc = new Scanner(System.in);
	static int[][] arr;

	public static void main(String[] args) {
		int N = sc.nextInt();
		sc.nextLine();
		arr = new int[N + 1][2];

		for (int i = 1; i <= N; i++) {
			String str = sc.nextLine();
			int idx = str.charAt(0) - 'A' + 1;
			if (str.charAt(2) != '.') {
				arr[idx][0] = str.charAt(2) - 'A' + 1;
			}
			if (str.charAt(4) != '.') {
				arr[idx][1] = str.charAt(4) - 'A' + 1;
			}

		}
		preorder(1);
		System.out.println();
		inorder(1);
		System.out.println();
		postorder(1);
		System.out.println();
		
	}

	static void preorder(int idx) {
		System.out.print((char)(idx+'A'-1));
		if (arr[idx][0] != 0) {
			preorder(arr[idx][0]);
		}
		if (arr[idx][1] != 0) {
			preorder(arr[idx][1]);
		}
	}
	static void inorder(int idx) {
		if (arr[idx][0] != 0) {
			inorder(arr[idx][0]);
		}
		System.out.print((char)(idx+'A'-1));
		if (arr[idx][1] != 0) {
			inorder(arr[idx][1]);
		}
	}
	static void postorder(int idx) {
		if (arr[idx][0] != 0) {
			postorder(arr[idx][0]);
		}
		if (arr[idx][1] != 0) {
			postorder(arr[idx][1]);
		}
		System.out.print((char)(idx+'A'-1));
	}
}
