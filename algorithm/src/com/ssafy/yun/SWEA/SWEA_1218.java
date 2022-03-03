package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1218 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static char[] arr;
	static Stack<Character> stack;

	public static void main(String[] args) throws IOException {
		for (int tc = 1; tc <= 10; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}
	}

	public static int solution() throws IOException {
		br.readLine();
		arr = br.readLine().toCharArray();
		stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (!check(arr[i])) {
				return 0;
			}
		}
		return 1;
	}

	static boolean check(char ch) {
		try {
			if (ch == ')') {
				if (stack.peek() != '(') {
					return false;
				}
				stack.pop();
				return true;
			}
			if (ch == '}') {
				if (stack.peek() != '{') {
					return false;
				}
				stack.pop();
				return true;
			}
			if (ch == ']') {
				if (stack.peek() != '[') {
					return false;
				}
				stack.pop();
				return true;
			}
			if (ch == '>') {
				if (stack.peek() != '<') {
					return false;
				}
				stack.pop();
				return true;
			}
		} catch (Exception e) {
			return false;
		}

		stack.push(ch);
		return true;
	}
}
