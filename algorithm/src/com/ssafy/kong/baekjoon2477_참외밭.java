package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon2477_참외밭{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] side = new int[6][2];
		for(int i = 0; i < 6; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; ++j) {
				side[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int maxW = 0 , maxH= 0, subW = 0, subH = 0;
		for(int i = 0; i < 6; ++i) {
			if( side[i][0] == 1 || side[i][0] == 2) {
				maxH = Math.max(maxH, side[i][1]); // 가로 중 가장 큰 값 구하기
				if( side[(i+1)%6][0] == side[((i-1)+6)%6][0] ) {
					subW = side[i][1];
				}
			}
			if( side[i][0] == 3 || side[i][0] == 4) {
				maxW = Math.max(maxW, side[i][1]); // 세로 중 가장 큰 값 구하기
				if( side[(i+1)%6][0] == side[((i-1)+6)%6][0] ) {
					subH = side[i][1];
				}
			}
		}

		System.out.println( (maxH*maxW - subH*subW) * n );
	}
}