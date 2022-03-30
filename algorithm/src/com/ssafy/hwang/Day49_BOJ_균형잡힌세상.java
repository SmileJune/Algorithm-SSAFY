package com.ssafy.hwang;

import java.util.Scanner;
import java.util.Stack;

public class Day49_BOJ_균형잡힌세상 {
	public static void main(String[] args) {
		Stack<Character> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			String flag = "yes";
			String s = sc.nextLine();
			if (".".equals(s)) {
				break;
			}
			char[] arr = s.toCharArray();
			for(int i=0;i<arr.length;i++) {
				int index = "([])".indexOf(arr[i]);
				if(index==0 ||index==1) {
					stack.add(arr[i]);
					continue;
				}
				if(index==3) {
					if(stack.empty() || stack.pop()!='(') {
						flag = "no";
						break;
					}
				}
				if(index==2) {
					if(stack.empty() || stack.pop()!='[') {
						flag = "no";
						break;
					}
				}
			}
			if(!stack.empty()) {
				flag ="no";
			}
			System.out.println(flag);
			stack.clear();
		}

	}
}
