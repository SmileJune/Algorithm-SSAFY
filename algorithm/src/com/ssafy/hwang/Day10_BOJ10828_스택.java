package com.ssafy.hwang;
/*
 * [ BOJ 10828 스택]
 * 
 * 스택 구현하는 문제
 * 주어진 조건에 맞는 정적배열만들면 시간초과 발생.
 * 기존의 메소드를 활용하여 출력
 */

import java.util.Scanner;
import java.util.Stack;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Day10_BOJ10828_스택 {
	static Stack<Integer> s = new Stack<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t = 0; t<T;t++) {
			String select = sc.next();
			switch(select) {
			case "push" : push(sc.nextInt()); break;
			case "top" : top(); break; 
			case "size" : size(); break;
			case "empty" : empty(); break;
			case "pop": pop(); break;
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
//	push X: 정수 X를 스택에 넣는 연산이다.
	private static void push(int i) {
		s.push(i);
	}
//	pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	private static void pop() {
		if(s.empty()) sb.append(-1).append("\n");
		
		else sb.append(s.pop()).append("\n");
	}
//	size: 스택에 들어있는 정수의 개수를 출력한다.
	private static void size() {
		sb.append(s.size()).append("\n");
	}
//	empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
	private static void empty() {
		if(s.empty()) sb.append(1).append("\n");
		else sb.append(0).append("\n");
	}
//	top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	private static void top() {
		if(s.empty()) sb.append(-1).append("\n");
		else sb.append(s.peek()).append("\n");
	}
}