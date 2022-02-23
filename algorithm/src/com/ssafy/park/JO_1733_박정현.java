package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1733_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int[][] arr = new int[21][21];
		int[] dr = { -1, 0, 1, 1};
		int[] dc = { 1, 1, 1, 0};
		for (int i = 1; i <= 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= 19; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		outer: for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				if (arr[i][j] != 0) {					
					for (int k = 0; k < 4; k++) {
						int cnt = 0;
						int r = i;
						int c = j;
						int cr = i + dr[k]*-1;
						int cc = j + dc[k]*-1;
						if (arr[i][j] != arr[cr][cc]) {							
							while (true) {
								r += dr[k];
								c += dc[k];
								if (0 < r && r < 20 && 0 < c && c < 20) {
									if (arr[i][j] == arr[r][c]) {
										cnt++;
									} else
										break;
								} else break;
							}
						}
						if (cnt == 4) {
							sb.append(arr[i][j] + "\n" + i + " " + j);
							break outer;
						}
					}
				}
			}
			if (i == 19) {				
				sb.append(0);
			}
		}
		System.out.println(sb);
	}
}
