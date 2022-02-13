package com.ssafy.kong;

import java.util.Scanner;

public class baekjoon16637_괄호추가하기 {
	static char[] op;
	static int[] num;
	static String st;
	static int n;
	static int ans = Integer.MIN_VALUE;
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		st = sc.next();
		num = new int[n/2+1];
		op = new char[n/2];
		for(int i = 0; i < n; ++i) {
			if(i%2 == 0)
				num[i/2] = Integer.parseInt(st.charAt(i) +"");
			else {
				op[i/2] = st.charAt(i);
			}
		}
		operation(0, num[0]);
		System.out.println(ans);
	}
 	static void operation(int index, int value) {
 		 // 더이상 계산하기 위한 연산자가 없음
 		if( index >= op.length ) {
 			ans = ans < value ? value : ans;
 			return;
 		}
 		// 괄호 자기 자신포함
 		int tmp = value;
 		value = calc(op[index], value, num[index+1]);
 		operation(index+1, value);
 		// 그 다음 연산에 괄호
 		if(index + 1 < op.length) {
 			tmp = calc(op[index], tmp, calc(op[index+1],
 					num[index+1], num[index+2]));
 			operation(index+2, tmp);
 		}
 	}
 	static int calc(char op, int num1, int num2) {
 		switch(op) {
 		case '+':
 			return num1 + num2;
 		case '-':
 			return num1 - num2;
 		case '*':
 			return num1 * num2;
 		}
 		return 0;
 	}
}