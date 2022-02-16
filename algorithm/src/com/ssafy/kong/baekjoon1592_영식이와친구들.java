package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1592_영식이와친구들{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int[][] ball = new int[n+1][2];
		for(int i = 0; i < n; ++i) {
			ball[i][0] = i;
		}
		int seq = 0;	// 공을 잡는 사람의 번호
		int cnt = 0; 	// 공을 던진 횟수
		ball[0][1] = 1;
		while(ball[seq][1] < m) {
			cnt++;
			seq += (2 % ball[seq][1] == 0)? (n-l): l;
			seq = seq % n;
			ball[seq][1]++;
		}
		System.out.println(cnt);
	}
}