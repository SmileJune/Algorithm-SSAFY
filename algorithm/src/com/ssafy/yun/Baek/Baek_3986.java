package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_3986 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int sum = 0;

		for (int tc = 1; tc <= N; tc++) {
			if (solution(br.readLine()))
				sum++;
		}

		System.out.println(sum);
	}

	static boolean solution(String str) {
		str = str.replaceAll("AA", "");
		str = str.replaceAll("BB", "");

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			// 비었을 때
			if (stack.empty()) {
				stack.push(ch);
				continue;
			}

			// 뭔가 있을 때
			if (stack.peek() == ch) {
				stack.pop();
			} else {
				stack.push(ch);
			}

		}

		if (!stack.empty())
			return false;

		return true;
	}
}
