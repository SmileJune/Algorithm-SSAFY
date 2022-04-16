package com.ssafy.ehoi;

import java.util.Scanner;
import java.util.Stack;

public class Day67_BOJ_S1_1254 {
	static String str;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		str = sc.next();

		if(check(str)) {
			System.out.println(str.length()); // 일단 주어진 문자열이 펠린드롬인지 확인
		} else { // 회문이 아니면 회문으로 만들어야지..
			for (int i = 0; i < str.length() - 1; i++) {
				if(check(makeStr(i))) {
					// 0부터 i까지의 문자열을 뒤에 추가해서 회문인지 검사해보자
					// 회문이면 출력하고 break
					System.out.println(makeStr(i).length());
					break;
				}
			}
		}
		
		
		sc.close();
	}

	// 문자열 추가해서 그 문자열 반환해야지
	private static String makeStr(int len) {
		Stack<Character> stack = new Stack<>();
		String copyStr = str;
		for (int i = 0; i <= len; i++) {
			stack.add(copyStr.charAt(i));
		}
		
		while(!stack.isEmpty()) {
			copyStr += stack.pop();
		}
		
		for (;!stack.isEmpty();) {
			copyStr += stack.pop();
		}
		
		return copyStr;
		
	}

	private static boolean check(String str) {
		boolean flag = true;
		int N = str.length();
		int size = str.length()/2; // 여기까지만 검사할거야
		for (int i = 0; i < size; i++) {
			if(str.charAt(i) != str.charAt(N-1-i)) {
				flag = false; // 다르기만하면 걍 회문 아님
				break;
			}
		}
		return flag;
	}
}
