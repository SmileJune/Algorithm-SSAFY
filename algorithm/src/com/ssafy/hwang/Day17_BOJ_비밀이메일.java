package com.ssafy.hwang;

import java.util.Scanner;

public class Day17_BOJ_비밀이메일 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		int n = 0;
		int N = str.length();
		int C = 0;
		int R = 0;
		for(int i=1; i<=N;i++) {
			if(N%i==0 && N/i>=i) {
				C = N/i;
				R = i;
			}
		}
		char[][] ans = new char[R][C];
		for(int col=0; col<C;col++) {
			for(int row=0; row<R;row++) {
				ans[row][col] = str.charAt(C*col +row);
				
			}
		}
		for(int i =0; i<R;i++) {
			for(int j= 0; j<C;j++) {
				System.out.print(ans[i][j]);
			}
		}
	}
}
