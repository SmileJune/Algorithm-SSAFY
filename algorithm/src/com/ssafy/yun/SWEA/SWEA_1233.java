package com.ssafy.yun.SWEA;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1233 {

	static class Node {
		int data;
		int left = -1;
		int right = -1;
	}

	static void recur(int idx) throws Exception {
		Node node = arr[idx];
		// 숫자일 경우 아래에 아무것도 없어야함
		if (node.data > 0) {
			if (node.left != -1 || node.right != -1) {
				throw new Exception();
			}
		}

		// 문자일 경우에는 아래에 두개가 있어야함
		if (node.left == -1 || node.right == -1) {
			throw new Exception();
		}

		recur(node.left);
		recur(node.right);

	}

	static Scanner sc = new Scanner(System.in);
	static Node[] arr;
	static StringTokenizer st;

	// + - * / 를 각각 -1 -2 -3 -4 로 저장하자.

	public static void main(String[] args) {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d\n", tc, solution());
		}
	}

	static int solution() {
		try {
		int len = Integer.parseInt(sc.nextLine());
		arr = new Node[len + 1];

		for (int n = 1; n <= len; n++) {
			st = new StringTokenizer(sc.nextLine());
			int index = Integer.parseInt(st.nextToken());
			String next = st.nextToken();
			// 숫자
			if (!"+-*/".contains(next)) {
				Node node = new Node();
				node.data = Integer.parseInt(next);
				arr[index] = node;
				continue;
			}

			// 연산자
			Node node = new Node();
			node.data = -1;
			//에러나면 0
			node.left = Integer.parseInt(st.nextToken());
			node.right = Integer.parseInt(st.nextToken());

			arr[index] = node;
		}

		recur(1);
		
		return 1;
		} catch(Exception e) {
			return 0; 
		}

	}

}
