package com.ssafy.yun.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1216 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static char[][] map = new char[100][100];
	public static char[][] transposeMap = new char[100][100];
	public static int max = 0;

	public static void main(String[] args) throws IOException {
		for (int i = 1; i <= 10; i++) {
			solution();
			System.out.printf("#%d %d%n", i, max);
			max = 0;
		}
	}

	public static void solution() throws IOException {
		br.readLine();

		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = str.charAt(j);
				transposeMap[j][i] = str.charAt(j);
			}
		}
		check(map);
		check(transposeMap);

	}

	public static void check(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			int len = 101;
			outer: while (true) {
				len -= 1;
				if (max >= len || len == 0) {
					break;
				}
				inner: for (int j = 0; j < arr[0].length - len + 1; j++) {
					for (int k = 0; k < len; k++) {
						if (arr[i][j + k] != arr[i][j + len - 1 - k]) {
							continue inner;
						}
					}
					max = len;
					break outer;
				}
			}

		}
	}

}
