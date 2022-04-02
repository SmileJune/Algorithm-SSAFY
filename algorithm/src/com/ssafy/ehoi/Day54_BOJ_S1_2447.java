package com.ssafy.ehoi;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Day54_BOJ_S1_2447 {
	static char[][] star;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		star = new char[n][n];
		

		recur(n, 0, 0);
		
		for(int i = 0; i < star.length; i++) {
			for (int j = 0; j < star[0].length; j++) {
				if (star[i][j] == '*') {
					bw.write(star[i][j]); 
				} else bw.write(' '); // 너 무 해! Char 기본값이 \0 
			}
			bw.write('\n');
		}
		bw.close();
		sc.close();
	}

	// 배열 크기, 행과 열의 시작 인덱스
	public static void recur(int size, int x, int y) {
		if (size == 1) {
			star[x][y] = '*';
			return;
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (!(i == 1 && j == 1)) {
					recur(size / 3, x + i * size / 3, y + j * size / 3);
				}
			}
		}

	}

}
