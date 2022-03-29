package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_1991 {

	// 문자를 숫자로 아스키 코드로 표현 해봐야겠다.
	// 'A' 65 -> 1 (-64)
	static Scanner sc = new Scanner(System.in);
	static Node[] arr;

	static class Node {
		int left;
		int right;
	}

	public static void main(String[] args) {
		int n = sc.nextInt();
		sc.nextLine();
		arr = new Node[n + 2];
		// 배열 초기화
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new Node();
		}
		for (int i = 1; i <= n; i++) {
			String str = sc.nextLine();
			int idx = str.charAt(0) - 'A' + 1;
			char first = str.charAt(2);
			char second = str.charAt(4);

			// 왼쪽
			if (first != '.') {
				arr[idx].left = first - 'A' + 1;
			}
			// 오른쪽
			if (second != '.') {
				arr[idx].right = second - 'A' + 1;
			}
			preOrder(1);
			System.out.println();
			inOrder(1);
			System.out.println();
			postOrder(1);
			System.out.println();
		}
	}

	static void preOrder(int idx) {
		System.out.print((char) (idx + 64));
		if (arr[idx].left == 0) {
			return;
		}
		preOrder(arr[idx].left);
		if (arr[idx].left == 0) {
			return;
		}
		preOrder(arr[idx].right);

	}

	static void inOrder(int idx) {
		if (arr[idx].left == 0) {
			return;
		}
		System.out.print((char) (idx + 64));
		inOrder(arr[idx].left);
		if (arr[idx].left == 0) {
			return;
		}
		inOrder(arr[idx].right);
	}

	static void postOrder(int idx) {
		if (arr[idx].left == 0) {
			return;
		}
		postOrder(arr[idx].left);
		if (arr[idx].left == 0) {
			return;
		}
		postOrder(arr[idx].right);
		System.out.print((char) (idx + 64));
	}
}
