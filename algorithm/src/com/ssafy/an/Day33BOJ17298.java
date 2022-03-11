package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Day33BOJ17298 { // 17298 오큰수 스택
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine()); 
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int idx = 0;
		while (st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && arr[stack.peek()] < arr[i])
				arr[stack.pop()] = arr[i];
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			arr[stack.pop()] = -1;
		}

		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\],]", ""));
		br.close();
	}
}
