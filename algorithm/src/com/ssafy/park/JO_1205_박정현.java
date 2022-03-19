package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1205_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String[] strarr = str.split(" ");
		int[] arr = new int[N];
		int count = 0;
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(strarr[n]);
			if (arr[n] == 0)
				count++;
		}
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (arr[j] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		int result = count;
		for (int i = count; i < N; i++) {
			int idx = i + 1;
			int cnt = count;
			while (idx < N) {
				int d = (arr[idx] - arr[idx - 1]);
				if (d == 0) {
					idx++;
					continue;
				}
				if (d - 1 <= cnt) {
					cnt = cnt - d + 1;
					idx++;
				} else
					break;
			}
			int temp = arr[idx - 1] - arr[i] + cnt + 1;
			if (result < temp) {
				result = temp;
			}
		}
		System.out.println(result);
	}
}
