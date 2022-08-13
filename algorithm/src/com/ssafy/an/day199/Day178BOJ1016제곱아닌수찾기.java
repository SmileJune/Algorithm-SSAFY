package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day178BOJ1016제곱아닌수찾기 {
	static int cnt, res;
	static long max, min;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		min = Long.valueOf(st.nextToken());
		max = Long.valueOf(st.nextToken());

		cnt = 0;
		res = (int) (max - min + 1);
		
		int sqrt = ((int) Math.sqrt(max));
		boolean[] checks = new boolean[res];

		for (long i = 2; i <= sqrt; i++) {
			long squared = i * i;
			long start = min % squared == 0 ? min / squared : (min / squared) + 1;
			for (long j = start; j * squared <= max; j++) {
				checks[(int) ((j * squared) - min)] = true;
			}
		}
		for (int i = 0; i < res; i++) {
			if (!checks[i])
				cnt++;
		}

		System.out.println(cnt);
		br.close();
	}
}
