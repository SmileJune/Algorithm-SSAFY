package com.ssafy.kong;

import java.util.Scanner;
 
public class BOJ_9663_NQeen {
 
	public static int[] arr;
	public static int N;
	public static int ans = 0;
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		nQueen(0);
		System.out.println(ans);
	}
 
	public static void nQueen(int d) {
		if (d == N) {
			ans++;
			return;
		}
 
		for (int i = 0; i < N; i++) {
			arr[d] = i;
			if (Possible(d)) {
				nQueen(d + 1);
			}
		}
 
	}
 
	public static boolean Possible(int c) {
 
		for (int i = 0; i < c; i++) {
			if (arr[c] == arr[i]) {
				return false;
			} 
			//대각선 찾기
			else if (Math.abs(c - i) == Math.abs(arr[c] - arr[i])) {
				return false;
			}
		}
		
		return true;
	}
}