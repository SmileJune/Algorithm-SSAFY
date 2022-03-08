package com.ssafy.hwang;

import java.util.Scanner;

public class Day29_BOJ_N과M1 {
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		int N = sc.nextInt();
		String s = "";
		solution(N, s);
	}
	static boolean[] check = new boolean[9];
	public static void solution(int N,String s) {
		if(N==0) {
			s = s.substring(1);
			System.out.println(s);
		}
		
		for(int i = 1 ;i<=M;i++) {
			if(check[i]) continue;
			check[i] = true;
			solution(N-1,s+" "+i);
			check[i] = false;
		}
		

	}
}
