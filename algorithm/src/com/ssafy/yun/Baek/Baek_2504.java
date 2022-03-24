package com.ssafy.yun.Baek;

import java.util.Scanner;
import java.util.Stack;

public class Baek_2504 {  //90퍼에서 틀린다 자꾸... 나중에 다시보자.

	static Scanner sc = new Scanner(System.in);
	static Stack<String> stack = new Stack<>();

	public static void main(String[] args) {
		String str = sc.next();

		String s = "";

		try {
			outer: for (int i = 0; i < str.length(); i++) {
				s = str.substring(i, i + 1);

				// ([ 일때
				if ("([".contains(s)) {
					stack.push(s);
					continue outer;
				}

				// )] 일때
				int idx = ")]".indexOf(s);
				String set = "([".substring(idx, idx + 1);
				int num = 0;
				while (!stack.isEmpty()) {
					// 꺼내서 숫자면 빼서 더해줘
					String out = stack.pop();

					if (out.length() >= 2 || '0' <= out.charAt(0) && out.charAt(0) <= '9') {
						num += Integer.parseInt(out);
						continue;
					}
					// 숫자가 아니고 set도 아니면 멈추기
					if (!out.equals(set)) {
						throw new Exception();
					}

					// set이면 이제까지 더한 숫자에 곱하기 2, 3 해주고 다시 넣어주기.
					if (set.equals("(")) {
						if (num == 0) {
							stack.push("2");
						} else {
							stack.push(num * 2 + "");
						}
						continue outer;
					}

					if (set.equals("[")) {
						if (num == 0) {
							stack.push("3");
						} else {
							stack.push(num * 3 + "");
						}
						continue outer;
					}

				}

			}
			// 다 돌았으면 들어있는 숫자들 다 더해줘
			int ans = 0;
			while (!stack.empty()) {
				String remainder = stack.pop();
				ans += Integer.parseInt(remainder);
				continue;
			}

			System.out.println(ans);
		} catch (Exception e) {
			System.out.println(0);
		}
	}

}
