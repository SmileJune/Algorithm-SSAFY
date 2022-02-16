package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1244_스위치켜고끄기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] swi = new int[n+2];
		for(int i = 1; i <= n; ++i) {
			swi[i] = Integer.parseInt(st.nextToken());
		}
		int stuN = Integer.parseInt(br.readLine());
		int[][] stu = new int[stuN][2];
		for(int i = 0; i < stuN; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 2; ++j)
				stu[i][j] = Integer.parseInt(st.nextToken());
		}
		swi[0] = -1;
		swi[n+1] = -1;
		// 계산의 편의성을 위해 처음과 끝부분에 0과 1이 아닌 수를 넣어준다.
		for(int i = 0; i < stuN; ++i) {
			if( stu[i][0] == 1 ) { // 남자이면
				for(int j = 1; j <= n; ++j) {
					if( j % stu[i][1] == 0 ) {	// 학생이 받은 번호의 배수 인덱스를 찾고,
						swi[j] = (swi[j]==0?1:0);	// 0이면 1을 넣고, 0이 아니면 0을 넣어라.
					}
				}
			}
			if( stu[i][0] == 2 ) { // 여자이면.
				int len = 0;
				int max = (n/2>=stu[i][1]? stu[i][1]:n-stu[i][1]);
				for(int j = 1; j <= max; ++j) {
					if( swi[stu[i][1]+j] != swi[stu[i][1]-j] ) {	
						break;
					}
					len++;
				}
				for(int k = -len; k <= len; ++k) {
	                swi[stu[i][1]+k] = (swi[stu[i][1]+k]==0?1:0);
				}
			}
		}
		for(int i = 1; i <= n; ++i) {
			sb.append(swi[i]).append(" ");
			if( i%20 == 0 )
				sb.append("\n");
		}
		System.out.println(sb);
	}
}
