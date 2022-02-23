package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day16BOJ4949균형잡힌괄호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] str;

		while (true) {
			Stack<Character> stack = new Stack<>();
			String ans = "yes";
			String tmp = br.readLine();
			if (tmp.equals("."))
				break;
			str = tmp.toCharArray();

			for (char c : str) {
				if (!"[{(]})".contains(c + ""))
					continue;
				if ("[{(".contains(c + "")) {
					stack.push(c);
					continue;
				}
				if (stack.isEmpty() || "[{(".indexOf(stack.pop()) != "]})".indexOf(c)) {
					ans = "no";
					break;
				}
			}
			ans = stack.isEmpty() ? ans : "no";
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
