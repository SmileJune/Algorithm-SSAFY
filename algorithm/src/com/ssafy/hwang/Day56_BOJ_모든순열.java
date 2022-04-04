package com.ssafy.hwang;

import java.util.Scanner;

public class Day56_BOJ_모든순열 {
	static int[] data;
	static int[] sel;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		data = new int[N];
		for(int i =0 ; i<N;i++) {
			data[i] = i+1;
		}
		sel = new int[N];
		perm(0,0);
	}

	private static void perm(int idx, int visited) {
		if(idx == N) {
			for(int i =0 ;i<N;i++) {
				System.out.print(sel[i] + " " );
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if((visited & (1<<i)) != 0) {
				continue;
			}
			
			sel[idx] = data[i];
			perm(idx+1, visited | 1 << i);
			
		}
		
	}
}
