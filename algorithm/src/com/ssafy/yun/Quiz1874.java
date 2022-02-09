package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Quiz1874 {

	public static int n = 1;
	public static int max;
	public static int[] arr;
	public static List<Integer> list = new ArrayList<>();
	public static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		max = Integer.parseInt(br.readLine());

		arr = new int[max];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		try {
			for (int i = 0; i < arr.length; i++) {
				check(arr[i]);
			}
		} catch (RuntimeException e) {
			System.out.println("NO");
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == 1) {
				System.out.println("+");
			} else {
				System.out.println("-");
			}
		}

	}

	public static void check(int target) throws RuntimeException {
		while (true) {
			if (target >= n) {
				stack.push(n);
				list.add(1);
				n++;
			}
			if (target < n) {
				if (stack.peek() != target) {
					throw new RuntimeException();
				}
				stack.pop();
				list.add(0);
				break;
			}
		}
	}

}
