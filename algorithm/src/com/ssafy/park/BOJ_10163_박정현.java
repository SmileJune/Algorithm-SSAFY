package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10163_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] bo = new int[1001][1001];
		int no = Integer.parseInt(br.readLine());
		int[] cnt = new int[no+1];
		for (int tc = 1; tc <= no; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int[] arr = new int[4];
			for (int i = 0; i < 4; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = arr[0]; i < arr[0] + arr[2]; i++) {
				for (int j = arr[1]; j < arr[1] + arr[3]; j++) {
					if (bo[i][j] != 0) {
						cnt[bo[i][j]]--;
					}
					bo[i][j] = tc;
					cnt[tc]++;
				}
			}
		}
		for (int i =1; i <=no; i++) {
			System.out.println(cnt[i]);
		}
		
	}
}
