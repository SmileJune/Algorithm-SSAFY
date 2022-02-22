package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874_스택수열 {
 public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuffer sb = new StringBuffer();
	int no = Integer.parseInt(br.readLine());
	int[] arr = new int[no];
	for ( int n = 0; n < no; n++) {
		arr[n] = Integer.parseInt(br.readLine());
	}
	Stack<Integer> stack = new Stack<>();
	stack.push(-1);
	int idx = 1;
	int cnt = 0;
	outer : for ( int i = 0; i < no; i++) {
		while (idx <= no+1) {
			if (stack.peek() == arr[i]) {
				sb.append("-" + "\n");
				cnt++;
				stack.pop();
				continue outer;
			} else {
				stack.push(idx);
				sb.append("+" + "\n");
				idx++;
			}
		}
	}
	if (cnt == no) System.out.println(sb);
	else System.out.println("NO");
}
}
