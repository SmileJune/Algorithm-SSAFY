package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon13300_방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] stu = new int[7][2]; // 학년 1~6, 남녀 성별
		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			int se = Integer.parseInt(st.nextToken());	// 성별
			int gr = Integer.parseInt(st.nextToken());	// 학년
			stu[gr][se]++;
		}
		int room = 0;
		for(int i = 1; i <=6; ++i) {
			for(int j = 0; j <= 1 ; ++j) {
				if( stu[i][j]%k != 0 )
					room++;
				room += stu[i][j]/k;
			}
		}
		System.out.println(room);
	}
}