package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day146BOJ2437저울정렬 { // 2437 저울
	static int N, cnt;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cnt = 0;
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			if (cnt + 1 < arr[i]) {
				break;
			}

			cnt += arr[i];
		}

		System.out.println(cnt + 1);
		br.close();
	}
}
