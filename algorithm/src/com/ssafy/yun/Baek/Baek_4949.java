package com.ssafy.yun.Baek;

import java.util.Scanner;
import java.util.Stack;

public class Baek_4949 {

	static Scanner sc = new Scanner(System.in);
	static String opening = "({[";
	static String closing = ")}]";

	public static void main(String[] args) {
		while (sc.hasNextLine()) {
			String input = sc.nextLine();

			// 입력이 끝나는 "." 신호인가 확인.
			if (input.equals(".")) {
				return;
			}

			if (isPerfect(input)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

	}

	static boolean isPerfect(String str) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			// 여는괄호일 경우 넣어준다.
			if (opening.contains(ch + "")) {
				stack.push(ch);
				continue;
			}

			// 닫는괄호일 경우 스택에서 하나를 빼서 확인
			if (closing.contains(ch + "")) {
				// 아무것도 없으면 false;
				if (stack.isEmpty()) {
					return false;
				}

				int idx = closing.indexOf(ch);
				if (stack.pop() != opening.charAt(idx)) {
					return false;
				}
				continue;
			}

			// 나머지는 무시
		}

		if (!stack.isEmpty()) {
			return false;
		}
		// 다 끝났는데 스택에 뭔가 남아있다 => false;

		return true;
	}

}
