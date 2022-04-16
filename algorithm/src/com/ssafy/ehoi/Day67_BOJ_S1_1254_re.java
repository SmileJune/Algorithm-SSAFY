package com.ssafy.ehoi;

import java.util.Scanner;
import java.util.Stack;

public class Day67_BOJ_S1_1254_re {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int n = str.length() - 1; // 기준 인덱스
		int need = 0;
		for (int i = 0; i < str.length(); i++) {
			if (n <= i) break; // 현재 인덱스가 기준 인덱스와 같거나 커졌다면(= 교차했다면) 더이상 보지 않아도 돼
			if(str.charAt(i) == str.charAt(n)) {
				n--; // 현재 인덱스와 기준의 문자가 같다면 기준 하나 왼쪽으로 이동
			} else {
				// 현재 인덱스와 기준 인덱스가 다르다면 현재 인덱스는 문자열 뒤에 붙어야 해 
				need = i + 1;
				n = str.length() - 1;
			}
		}
		System.out.println(str.length() + need);
		
		
		sc.close();
	}
}
