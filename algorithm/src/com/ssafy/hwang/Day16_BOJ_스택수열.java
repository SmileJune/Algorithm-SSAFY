package com.ssafy.hwang;

import java.util.Scanner;
import java.util.Stack;

/**
 * [BOJ_스택수열]
 * 
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 주어지는 수열을 만들수 있다면 push는 +, pop은 -로 표현하여 출력한다.
 * 불가능한 경우에는 NO를 출력한다.
 * 
 * input : 첫줄에 n 입력받음. 둘째 줄부터 1~n 정수가 하나씩 주어진다. (정수가 중복되는 경우는 없다.)
 * 
 * output : 한줄에 한개씩 연산을 출력. 주어지는 수열을 만들수 있다면 push는 +, pop은 -로 표현하여 출력 불가능한 경우에는
 * NO를 출력한다.
 */
public class Day16_BOJ_스택수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 결과값을 StringBuilder에 모아서 마지막에 출력해주자.
		StringBuilder sb = new StringBuilder();
		// 몇까지의 정수를 다룰 지 확인한다.
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		int i = 1;
		boolean flag = true;
		stack.push(i++);
		sb.append("+\n");
		outer: while (true) {
			int impare = sc.nextInt();
			while (true) {
				if (stack.empty()) {
					stack.push(i++);
					sb.append("+\n");
					continue;
				}
				if (impare > stack.peek()) {
					stack.push(i++);
					sb.append("+\n");
					continue;
				}
				if (impare == stack.peek()) {
					stack.pop();
					sb.append("-\n");
					break;
				}
				if (i > impare) {
					flag = false;
					break outer;
				}
			}
			if(i==N+1&&stack.empty()) break;
		}
		if (!flag)
			System.out.println("NO");
		else {
			System.out.println(sb.toString());
		}
	}
}
