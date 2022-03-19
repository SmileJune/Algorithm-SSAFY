package com.ssafy.park;

import java.util.Scanner;

public class BOJ_14501_퇴사 {
	static int N;
	static int[][] arr;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2];
		
		for(int i=0;i<N;i++) {
			arr[i][0] = sc.nextInt(); 
			arr[i][1] = sc.nextInt(); 
		}
		
		result = 0; 
		cal(0,0);
		
		System.out.println(result);
	}
	public static void cal(int idx, int pay) {
		if(idx>=N) {
			result = Math.max(result, pay);
			return;
		}
		
		if(idx+arr[idx][0]<=N) cal(idx+arr[idx][0], pay + arr[idx][1]);
		else cal(idx+arr[idx][0], pay);
		
		cal(idx+1,pay);
	}
}