package com.ssafy.park;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q17425_약수의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long[] dp = new long[1000001];
		dp[0] = 0;
		for (int i = 1; i <= 1000000; i++) {
			dp[i] += i;
			for (int j = i+i; j<=1000000; j +=i) {
				dp[j] += i;
			}
			dp[i] += dp[i-1];
		}
		int no = Integer.parseInt(br.readLine());
		for (int tc=0; tc < no; tc++) {
			int num = Integer.parseInt(br.readLine());
			bw.write(dp[num] + "\n");
		}
		bw.flush();
	}
}
