package com.ssafy.hwang;

import java.util.Scanner;
import java.util.Stack;

public class Day49_BOJ_제로 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int sum =0;
		for(int i =0; i<k;i++) {
			int n = sc.nextInt();
			if(n==0) {
				sum -= stack.pop();
			}else {
				stack.add(n);
				sum += n;
			}
			
		}
		System.out.println(sum);
	}
}
