package com.ssafy.an;

import java.util.Scanner;

public class Day56SW2112보호필름DFSBestSol { // SW 2112 보호필름
	static int D;
	static int W;
	static int K;
	static int[][] array;
	static int[][] temp;
	static int Min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();

		Loop1: for (int i = 0; i < test_case; i++) {
			Min = Integer.MAX_VALUE;
			D = sc.nextInt(); // 두께
			W = sc.nextInt(); // 가로
			K = sc.nextInt(); // 합격기준
			// A:0 , B:1
			array = new int[D][W];
			temp = new int[D][W];
			for (int t = 0; t < D; t++) {
				for (int k = 0; k < W; k++) {
					array[t][k] = sc.nextInt();
					temp[t][k] = array[t][k];
				}
			}

			int temp = 2;
			int cnt = 0;
			int test = 0;
			for (int k = 0; k < W; k++) {
				temp = 2;
				cnt = 0;
				int check = 0;
				for (int t = 0; t < D; t++) {
					if (temp == array[t][k]) {
						cnt++;
						if (cnt == K - 1) {
							test++;
							cnt = 0;
							check = 1;
							break;
						}
					} else {
						cnt = 0;
					}
					temp = array[t][k];
				}
				if (check == 0) {
					break;
				}

			}

			if (test == W) {
				System.out.print("#" + (i + 1) + " ");
				System.out.println("0");
				// break Loop1;
			} else {
				back(0, 0);
				System.out.print("#" + (i + 1) + " ");
				System.out.println(Min);
				// break Loop1;
			}
		}

	}

	static int temp2 = 2;
	static int test2 = 0;
	static int cnt = 0;

	static void back(int idx, int cnt2) {
		// (0,0)(1,0)(2,0)
		temp2 = 2;
		test2 = 0;
		cnt = 0;

		if (cnt2 == K) {
			if (Min > cnt2) {
				Min = cnt2;
			}
			return;
		}

		for (int k = 0; k < W; k++) {
			temp2 = 2;
			cnt = 0;
			int check = 0;
			for (int t = 0; t < D; t++) {
				if (temp2 == array[t][k]) {
					cnt++;
					if (cnt == K - 1) {
						test2++;
						cnt = 0;
						check = 1;
						break;
					}
				} else {
					cnt = 0;
				}
				temp2 = array[t][k];
			}
			if (check == 0) {
				break;
			}

		}

		if (test2 == W) {
			// System.out.println("@");
			if (Min > cnt2) {
				Min = cnt2;
			}
		}

		for (int i = idx; i < D; i++) {
			for (int j = 0; j < W; j++) {
				array[i][j] = 0;
			}
			back(i + 1, cnt2 + 1);

			for (int j = 0; j < W; j++) {
				array[i][j] = 1;
			}
			back(i + 1, cnt2 + 1);

			for (int j = 0; j < W; j++) {
				array[i][j] = temp[i][j];
			}
		}
	}
}
