package com.ssafy.yun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_1702 {

	public static Scanner sc = new Scanner(System.in);
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static List<Integer> list;
	static int[] arr;

	public static void main(String[] args) throws IOException {

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			solution();
			bw.write("#" + tc + " ");
			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i) + " ");
			}
			bw.write("\n");
		}

		bw.close();
	}

	static void solution() {
		list = new ArrayList<>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N + M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i + j]++;
			}
		}
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == max) {
				list.add(i);
			}
		}

	}

}
