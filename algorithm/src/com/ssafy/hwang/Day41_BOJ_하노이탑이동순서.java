package com.ssafy.hwang;

import java.util.Scanner;

public class Day41_BOJ_하노이탑이동순서 {
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb= new StringBuilder();
		int N = sc.nextInt();
		sb.append((int)Math.pow(2, N)-1 +"\n");
		hanoi(1,2,3,N);
		System.out.println(sb);
	}
	public static void hanoi(int from,int tmp, int to,int n) {
		if(n==0) {
			return;
		}
		
		
		hanoi(from,to,tmp,n-1);
		sb.append(from + " "+ to + "\n");
		if(n!=1) {
			hanoi(tmp,from,to,n-1);			
		}
	}
}
