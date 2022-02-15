package com.ssafy.yun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class SWEA_1954 {

	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Scanner sc = new Scanner(System.in);
	public static int[][] arr;
	public static int[] dc = { 1, 0, -1, 0 };
	public static int[] dr = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			solution();
			bw.write("#" + tc + "\n");
			for (int i = 0; i < arr[0].length; i++) {
				for (int j = 0; j < arr.length; j++) {
					bw.write(arr[i][j] + " ");
				}
				bw.write("\n");
			}
		}
		bw.close();
	}

	public static void solution() {
		int len = sc.nextInt();
		if (len == 1) {
			arr = new int[1][1];
			arr[0][0] = 1;
			return;
		}
		
		int num = 1;
		arr = new int[len][len];
		boolean[][] visited = new boolean[len][len];
		int row = 0;
		int col = -1;

		while (num <= len * len) {
			// 오른쪽 한번 들어가면 쭉
			while (true) {
				row += dr[0];
				col += dc[0];

				if (col >= len) {
					row -= dr[0];
					col -= dc[0];
					break;
				}
				if (visited[row][col] == true) {
					row -= dr[0];
					col -= dc[0];
					break;
				}

				visited[row][col] = true;
				arr[row][col] = num++;
			}

			// 아래 한번 들어가면 쭉
			while (true) {
				row += dr[1];
				col += dc[1];

				if (row >= len) {
					row -= dr[1];
					col -= dc[1];
					break;
				}
				if (visited[row][col] == true) {
					row -= dr[1];
					col -= dc[1];
					break;
				}

				visited[row][col] = true;
				arr[row][col] = num++;
			}

			// 왼쪽에 한번 들어가면 쭊
			while (true) {
				row += dr[2];
				col += dc[2];

				if (col < 0) {
					row -= dr[2];
					col -= dc[2];
					break;
				}

				if (visited[row][col] == true) {
					row -= dr[2];
					col -= dc[2];
					break;
				}

				visited[row][col] = true;
				arr[row][col] = num++;
			}

			// 위쪽 한번 들가면 쭉
			while (true) {
				row += dr[3];
				col += dc[3];

				if (visited[row][col] == true) {
					row -= dr[3];
					col -= dc[3];
					break;
				}

				visited[row][col] = true;
				arr[row][col] = num++;
			}

		}
	}

}
