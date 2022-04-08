package com.ssafy.hwang;

import java.util.Scanner;

public class Day60_BOJ_종이의개수 {
	static int map[][], res[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		map = new int[N][N];
		res = new int[3]; // [0]: -1갯수, [1]: 0 갯수, [2]: 1갯수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		} // 입력 처리 끝

		recur(0, 0, N);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}

	static boolean isSame;

	private static void recur(int r, int c, int size) {
		if (size == 1) {
			
			res[map[r][c] + 1]++;
			return;
		}
		int comp = map[r][c];
		isSame = true;
		outer: for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] != comp) {
					isSame = false;
					break outer;
				}
			}
		}
		if(isSame) {
			res[comp+1]++; 
		}else {
			size /= 3;
			recur(r,c,size);
			recur(r,c+size,size);
			recur(r,c+size*2,size);
			recur(r+size,c,size);
			recur(r+size,c+size,size);
			recur(r+size,c+size*2,size);
			recur(r+size*2,c,size);
			recur(r+size*2,c+size,size);
			recur(r+size*2,c+size*2,size);
		}
		
	}
}