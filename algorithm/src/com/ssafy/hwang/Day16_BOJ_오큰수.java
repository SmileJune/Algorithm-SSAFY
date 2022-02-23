package com.ssafy.hwang;

import java.util.Scanner;
import java.util.Stack;

public class Day16_BOJ_오큰수 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			
			while(!stack.empty() && arr[stack.peek()] < arr[i]) {
				arr[stack.pop()] = arr[i];
				
			}
			stack.push(i);
			
		}
		while(!stack.empty())
			arr[stack.pop()] = -1;
		
		
		for(int i = 0; i < N; i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);
	}
}
