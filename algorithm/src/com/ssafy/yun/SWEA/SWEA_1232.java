package com.ssafy.yun.SWEA;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1232 {
	
	static class Node{
		int data;
		int left;
		int right;
	}

	static double recur(int idx) {
		Node node = arr[idx];
		int num = node.data;
		
		//숫자일 때
		if (num > 0)
			return num;

		//연산자일 때
		if (num == -1)
			return recur(node.left) + recur(node.right);
		else if (num == -2)
			return recur(node.left) - recur(node.right);
		else if (num == -3)
			return recur(node.left) * recur(node.right);
		else
			return recur(node.left) / recur(node.right);
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
		int len = Integer.parseInt(sc.nextLine());
		arr = new Node[len + 1];
		
		for(int n=1; n<=len; n++) {
			st = new StringTokenizer(sc.nextLine());
			int index = Integer.parseInt(st.nextToken());
			String next = st.nextToken();
			//숫자
			if(!st.hasMoreTokens()) {
				Node node = new Node();
				node.data = Integer.parseInt(next);
				arr[index] = node;
				continue;
			}
			
			//연산자
			Node node = new Node();
			node.data = -1-("+-*/".indexOf(next));
			node.left = Integer.parseInt(st.nextToken());
			node.right = Integer.parseInt(st.nextToken());
			arr[index] = node;
		}
		return (int) recur(1);
	}

}
