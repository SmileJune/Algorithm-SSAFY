package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class Day174BOJ103636진수 { // 1036 36진수 구선생님 도움
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BigInteger ret = BigInteger.ZERO;
		BigInteger[] diff = new BigInteger[36];
		Arrays.fill(diff, BigInteger.ZERO);
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String raw = br.readLine();
			BigInteger now = new BigInteger(raw, 36);
			BigInteger pow = BigInteger.ONE;
			ret = ret.add(now);
			for (int j = 0; j < raw.length(); j++) {
				int idx = Dec(raw.charAt(raw.length() - 1 - j));
				diff[idx] = diff[idx].add(pow.multiply(BigInteger.valueOf(35 - idx)));
				pow = pow.multiply(BigInteger.valueOf(36));
			}
		}
		Arrays.sort(diff);
		int K = Integer.parseInt(br.readLine());
		for (int i = 35; K-- > 0; i--)
			ret = ret.add(diff[i]);
		bw.write(ret.toString(36).toUpperCase());
		bw.close();
	}

	static int Dec(char x) {
		return ('0' <= x && x <= '9') ? x - 48 : x - 55;
	}
}
