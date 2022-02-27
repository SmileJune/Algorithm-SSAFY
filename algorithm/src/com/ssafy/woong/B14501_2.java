package com.ssafy.woong;

import java.util.Scanner;
import java.util.Stack;

public class B14501_2{
	static int income[][];
	static int N, Max, money;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextInt();
		income = new int [N][2];
		
		for (int i = 0; i < N; i++) {
			//0번째 열에는 걸리는 시간
			income[i][0] = sc.nextInt();
			//1번째 열에는 얻을 수 있는 돈
			income[i][1] = sc.nextInt();
		}
		quitC(0, 0);
		System.out.println(Max);
		
	}
	
	static void quitC(int idx, int sum) {
		
		// idx 넘어가면 그전의 sum만큼 출력
		if(idx >= N) {
			if(sum > Max) {
				Max = sum;
			}
			return;
		}
		if(idx + income[idx][0] <= N) {
			quitC(idx + income[idx][0], sum + income[idx][1]);
		}
		
		// for문 대신 쓰기
		quitC(idx + 1, sum);
	}
}