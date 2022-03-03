package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baek_2824 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arrA = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arrA.length; i++) {
			arrA[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		int[] arrB = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arrB.length; i++) {
			arrB[i] = Integer.parseInt(st.nextToken());
		}

		BigInteger GCD = new BigInteger("1");
		for (int i = 0; i < arrA.length; i++) {
			for (int j = 0; j < arrB.length; j++) {
				int eachGCD = recur(arrA[i], arrB[j]);
				arrA[i] /= eachGCD;
				arrB[j] /= eachGCD;
				GCD = GCD.multiply(new BigInteger("" + eachGCD));
			}
		}

		// 9자리 이하면 바로 출력
		if (("" + GCD).length() <= 9) {
			System.out.println(GCD);
			return;
		}

		// 초과면 마지막 9자리까지만 출력
		StringBuffer sb = new StringBuffer("" + GCD);
		System.out.println(sb.substring(sb.length() - 9));

	}

	static int recur(int A, int B) {
		if (B == 0) {
			return A;
		}
		return recur(B, A % B);
	}

}
