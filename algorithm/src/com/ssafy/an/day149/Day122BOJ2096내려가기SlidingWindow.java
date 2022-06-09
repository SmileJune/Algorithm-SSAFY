package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Day122BOJ2096내려가기SlidingWindow { // 2096 내려가기 슬라이딩 윈도우
	static StringTokenizer st;
	static int N, max, min;
	static int[] tmp, tmpDP, maxDP, minDP;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		tmp = new int[] { ipsn(), ipsn(), ipsn() };
		maxDP = new int[] { tmp[0], tmp[1], tmp[2] };
		minDP = new int[] { tmp[0], tmp[1], tmp[2] };

		for (int i = 1; i < N; i++) { // init에서 1줄 사용
			st = new StringTokenizer(br.readLine());
			tmp = new int[] { ipsn(), ipsn(), ipsn() };

			tmpDP = new int[] { maxDP[0], maxDP[1], maxDP[2] };
			maxDP[0] = Math.max(tmpDP[0], tmpDP[1]) + tmp[0];
			maxDP[2] = Math.max(tmpDP[1], tmpDP[2]) + tmp[2];
			maxDP[1] = Math.max(Math.max(tmpDP[0], tmpDP[1]), tmpDP[2]) + tmp[1];

			tmpDP = new int[] { minDP[0], minDP[1], minDP[2] };
			minDP[0] = Math.min(tmpDP[0], tmpDP[1]) + tmp[0];
			minDP[2] = Math.min(tmpDP[1], tmpDP[2]) + tmp[2];
			minDP[1] = Math.min(Math.min(tmpDP[0], tmpDP[1]), tmpDP[2]) + tmp[1];
		}

		bw.write(Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2])) + " ");
		bw.write(Math.min(minDP[0], Math.min(minDP[1], minDP[2])) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static int ipsn() { // 토큰 바로 배열 만들기
		return Integer.parseInt(st.nextToken());
	}
}
