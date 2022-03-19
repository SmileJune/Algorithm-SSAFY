package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day12_BOJ_S4_10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Stack<Integer> stack = new Stack<>();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			
			if (input.contains("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
			}
			else if (input.contains("pop")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				}
				else System.out.println(stack.pop());
			} 
			else if (input.contains("size")) {
				System.out.println(stack.size());
			} 
			else if (input.contains("empty")) {
				if (stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if (input.contains("top")) {
				if (stack.isEmpty()) System.out.println(-1);
				else System.out.println(stack.peek());
			}
			
		}
		
		
	}
}
