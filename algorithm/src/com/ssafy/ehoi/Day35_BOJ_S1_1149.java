package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 그냥 인접한 집이랑 색깔 다르면 되는 문제
 * top-down으로 풀고 싶은데 일단
 * bottom-up으로 먼저 풀어보자 
 *
 */
public class Day35_BOJ_S1_1149 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 입력이 1,000 * 3 이나 들어올 거니까 버퍼로 받자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 집의 수 받기
		
		int[][] cost = new int[N][3]; //비용 배열
		
		// 0 빨 1 초 2 파
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		// 누적합하자
		for (int i = 1; i < N; i++) {
			cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]); 
			cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]); 
			cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]); 
		}
		
		System.out.println(Math.min(cost[N-1][0], Math.min(cost[N-1][1], cost[N-1][2])));
	}
}
