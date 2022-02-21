package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_박정현 {
  public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	int N = Integer.parseInt(st.nextToken());
	int K = Integer.parseInt(st.nextToken());
	int[][] arr= new int[2][6];
	for ( int i = 0 ; i < N; i++) {
		st = new StringTokenizer(br.readLine(), " ");
		arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())-1]++;
	}
	int cnt = 0;
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 6; j++) {
			if ( arr[i][j] % K != 0) {
				cnt += arr[i][j] / K + 1;
			} else {
				cnt += arr[i][j] / K;
			}
		}
	}
	System.out.println(cnt);
}
}
