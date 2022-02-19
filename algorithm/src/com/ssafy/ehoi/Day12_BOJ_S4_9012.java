package com.ssafy.ehoi;

import java.util.Scanner;
import java.util.Stack;

public class Day12_BOJ_S4_9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			Stack<Character> stack = new Stack<>(); // 스택을 매번 새로 생성해서 써야지 태이야 
			String bracket = sc.next();
			boolean ok = true ; // 이번 괄호는 유효할거야 
			for (int j = 0; j < bracket.length(); j++) {
				char c = bracket.charAt(j);
				
				if(c == '(') { // 열린 괄호라면
					stack.push(c);
					continue;
				} 
				// 닫힌 괄호라면
				if (stack.isEmpty()) { // 꺼내기 전에, 스택이 비었는지 확인
					ok = false; // 에잇 유효하지 않아
					break; // 이번 턴은 끝이야
				}
				// 스택에 열린 괄호가 있다면
				stack.pop(); // 열린괄호 하나 꺼내주세요
			}
			// 이번 턴 검사 끝
			if (!stack.isEmpty()) { // 근데 스택에 열린괄호가 들어있다?
				ok = false;
			}
			if (ok) {
				System.out.println("YES");
			} else System.out.println("NO");
			
		}
		
		sc.close();
	}
}
