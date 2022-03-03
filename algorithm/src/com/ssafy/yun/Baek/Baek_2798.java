package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2798 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	static int[] arr;
	static int max = 0, N, M;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		powerSet(0, 0, 0);
		System.out.println(max);
	}

	public static void powerSet(int idx, int sum, int cnt) {
		if (cnt == 3) {
			if (sum <= M) {
				max = Math.max(max, sum);
			}
			return;
		}
		if (idx == arr.length) {
			return;
		}

		powerSet(idx + 1, sum, cnt);
		powerSet(idx + 1, sum + arr[idx], ++cnt);

	}

}
