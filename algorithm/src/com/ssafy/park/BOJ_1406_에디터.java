package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1406_에디터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String str = br.readLine();
		Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			stack1.push(str.charAt(i));
		}
		int no = Integer.parseInt(br.readLine());
		for (int n = 0; n < no; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String temp = st.nextToken();
			if (temp.equals("L")) {
				if (!stack1.isEmpty())
				stack2.push(stack1.pop());
			} else if (temp.equals("D")) {				
				if (!stack2.isEmpty())
				stack1.push(stack2.pop());
			}
			else if (temp.equals("B")) {
				if (!stack1.isEmpty())
				stack1.pop();
			} else {
					stack1.push(st.nextToken().charAt(0));
				}
			}
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		while (!stack2.isEmpty()) {
			sb.append(stack2.pop());
		}
		
		System.out.println(sb);
	}
}
