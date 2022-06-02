package com.ssafy.an.day099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day60BOJ1629LONG제곱분할정복 { // 1629 곱셈 분할정복
	static long A, B, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		System.out.println(pow(A, B));

		br.close();
	}

	private static long pow(long a, long b) {
		if (b == 1)
			return a % C;
		long res = pow(a, b / 2);
		return (res * res % C) * ((b % 2 == 1) ? a : 1) % C;
	} // 최종...? C를 주는 이유가 있었다.

	private static int pow2(int a, int b) {
		if (b == 1)
			return a;
		int res = pow2(a, b / 2);
		return res * res * ((b % 2 != 0) ? a : 1);
	} // 기억해 둬도 문제가 틀린다고 나옴 > tc 범위가 long형을 벗어나고, c로 매번 나누는 알고리즘 짜야함.

	private static int pow1(int a, int b) {
		return (b < 1) ? 1 : pow1(a, b / 2) * pow1(a, b / 2) * ((b % 2 != 0) ? a : 1);
	} // 한줄로 만들면 시간초과... result 기억 방식으루..
}
