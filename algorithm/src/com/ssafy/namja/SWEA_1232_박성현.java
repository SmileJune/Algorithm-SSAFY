package com.ssafy.namja;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1232_박성현 {
	static String[] heap;
	static int[][] hasChild;
	static StringBuffer sb;
	static String operator = "+-*/";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			sc.nextLine();
			heap = new String[N + 1];
			hasChild = new int[N + 1][2];
			sb = new StringBuffer();
			for (int i = 0; i < N; i++) {
				String line = sc.nextLine();
				st = new StringTokenizer(line);
				
				int idx = Integer.parseInt(st.nextToken());
				String word =st.nextToken();
				int n = 0;
				while (st.hasMoreTokens()) {
					hasChild[idx][n++] = Integer.parseInt(st.nextToken());
				}
				heap[idx] = word;
			}
			// 전위연산 코드 복붙
			inOrder(1);
			System.out.printf("#%d %s\n", t, heap[1]);
		}
		
	}
	
	static void inOrder(int idx) {
		int leftChild = hasChild[idx][0];
		int rightChild = hasChild[idx][1];
		if (leftChild != 0)
			inOrder(leftChild);
		sb.append(heap[idx]);
		if (rightChild != 0) {
			inOrder(rightChild);
		}
		if (operator.contains(heap[idx])) {
		char oper = heap[idx].charAt(0);
		int ans = 0;
		switch (oper) {
		case '+':
			ans = Integer.parseInt(heap[leftChild]) + Integer.parseInt(heap[rightChild]);
			break;
		case '-':
			ans = Integer.parseInt(heap[leftChild]) - Integer.parseInt(heap[rightChild]);
			break;
		case '*':
			ans = Integer.parseInt(heap[leftChild]) * Integer.parseInt(heap[rightChild]);
			break;
		case '/':
			ans = Integer.parseInt(heap[leftChild]) / Integer.parseInt(heap[rightChild]);
			break;
		}
		heap[idx] = ans + "";
		}
	}
}