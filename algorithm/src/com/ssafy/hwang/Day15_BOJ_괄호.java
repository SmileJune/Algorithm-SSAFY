package com.ssafy.hwang;
import java.util.Scanner;
import java.util.Stack;

/**
 * BOJ_괄호
 * 주어진 괄호 문자열이 올바른지 아닌지를 판단하는 문제.
 * 
 * 테스트 케이스 갯수 T를 입력받음.
 * '('와 ')'로만 구성되어있는 문자열을 입력받음.
 * 올바른 괄호 문자열이면 "YES", 아니면 "NO"를 출력.
 */
public class Day15_BOJ_괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			boolean flag =true ;
			Stack<Character> stack = new Stack<>();
			String str = sc.next();
			char[] cArr = str.toCharArray();
			for (char c : cArr) {
				if (c == '(') stack.push(c); 
				else{
					if(stack.empty() || !(stack.peek()=='(')) {
						flag = false;
						break;
					}
					stack.pop();
				}
			}
			if(!stack.empty()||!flag) System.out.println("NO");
			else System.out.println("YES");
		}
		sc.close();
	}
}
