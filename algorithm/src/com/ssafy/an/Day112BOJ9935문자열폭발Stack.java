package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Day112BOJ9935문자열폭발Stack { // 9935 문자열 폭발
	static int N, M;
	static char[] str, bob;
	static Stack<Character> stack;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine().toCharArray();
		N = str.length; // 전체 순회 길이 ~ 1_000_000
		bob = br.readLine().toCharArray();
		M = bob.length; // 부분 순회 길이 ~ 36
		stack = new Stack<>();
		// StringBuilder이나 Dequeue로 조건부 삽입해도 가능하나, stack이 뒤로 돌아가기 편하다.

		for (int i = 0; i < N; i++) {
			stack.push(str[i]);
			if (stack.size() >= M)
				check();
		}

		System.out.println(stack.size() > 0 ? stack.toString().replaceAll("[\\[\\], ]", "") : "FRULA");
		br.close();
	}

	// i값이 부여되어야 하나 생각했는데, stack으로하면 size로 관리가능
	private static void check() {
		boolean bomb = true; // 다른 지 체크로 반복문 탈출
		int st = stack.size() - M; // 현재 check 진입 시 확인 시작지점
		for (int i = 0; i < M; i++) {
			if (stack.get(st + i) != bob[i]) {
				bomb = false;
				break;
			}
		}
		if (bomb)
			for (int i = 0; i < M; i++)
				stack.pop();

	}
}
