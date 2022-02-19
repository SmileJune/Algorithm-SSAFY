package com.ssafy.ehoi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Day12_BOJ_G3_1918 {
	static Map<Character, Integer> priority = new HashMap<>();
	
	static {
		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Stack<Character> stack = new Stack<>();
		StringBuilder post = new StringBuilder();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// 알파벳 대문자라면
			if(c >= 'A' && c<= 'Z') {
				post.append(c);
				continue;
			}
			// 여기서부터는 스택에 뭐든 하나는 있다.
			// 괄호라면
			// 여는 괄호라면
			else if(c == '(') { // 눈치 없는 이 친구 그냥 들어가고 본다
				stack.push(c);
				continue;
			}
			// 닫는 괄호라면
			// 여는 괄호를 꺼내는게 목적
			// 근데 그전에 연산자 죄다 꺼낸다 (반복 : 여는 괄호 만날때까지 = 여는 괄호가 아닐때까지)
			// 꺼낸 거 포스트에 붙인다.
			else if (c == ')') {
				while(stack.peek() != '(') { // 근데 무조건 여는 괄호 있을 테니까 스택이 빌 거는 걱정 안해도 돼
					post.append(stack.pop());
				}
				stack.pop(); // 너 이제 여는 괄호지 너 나와
				continue;
			}
			// 연산자라면
			// 대문자도 아니고 괄호도 아니라면 처음에 들어가는 거라면? 무엇이든 편하게 입장~
			if(stack.isEmpty()) {
				stack.push(c);
				continue;
			}
			// 우선순위를 고려해야 하고 
			// 스택에 빌 것을 고려해야해 
			while(!stack.isEmpty() && priority.get(c) <= priority.get(stack.peek())) {
				post.append(stack.pop());
			}
			stack.push(c);
			
		}
		// 스택에 남은 연산자 꺼내서 붙여줘 
		while (!stack.isEmpty()) {
			post.append(stack.pop());
		}
		
		System.out.println(post.toString());
		
		sc.close();
	}
}
