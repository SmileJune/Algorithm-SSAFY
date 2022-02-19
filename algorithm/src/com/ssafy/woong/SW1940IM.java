package com.ssafy.woong;

import java.util.Scanner;

public class SW1940IM {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int v = 0;
			int dist = 0;
			int N = sc.nextInt();
			for(int i = 0 ; i < N; i++) {
				
				int order = sc.nextInt();
				int val;
				switch(order) {
				case 0:
					break;
				case 1:
					val = sc.nextInt();
					v += val;
					break;
				case 2:
					val = sc.nextInt();
					v = val > v ? 0 : v-val;
					break;
				}
				dist += v;
			}
			System.out.printf("#%d %d\n",tc,dist);
		}
	}
}
