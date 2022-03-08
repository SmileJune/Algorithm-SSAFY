package com.ssafy.yun.Baek;

import java.net.Socket;
import java.util.Scanner;
import java.util.Stack;

public class Baek_10773 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if (num == 0) {
				stack.pop();
				continue;
			}
			stack.push(num);
		}

		int max = 0;
		for (int i = 0; i < stack.size(); i++) {
			max += stack.get(i);
		}
		System.out.println(max);
	}

}
