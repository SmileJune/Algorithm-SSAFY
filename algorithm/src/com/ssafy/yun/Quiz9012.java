package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Quiz9012 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static String[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int num = Integer.parseInt(br.readLine());
		for (int i = 1; i <= num; i++) {
			System.out.println(check());
		}
	}

	public static String check() throws IOException {
		arr = br.readLine().split("");

		Stack<Integer> stack = new Stack<>();
		try {
			for (int i = 0; i < arr.length; i++) {
				if (arr[i].equals("(")) {
					stack.push(new Integer(1));
				}
				if (arr[i].equals(")")) {
					stack.pop();
				}
			}

			if (stack.isEmpty()) {
				return "YES";
			} else {
				return "NO";
			}

		} catch (EmptyStackException e) {
			return "NO";
		}
	}

}
