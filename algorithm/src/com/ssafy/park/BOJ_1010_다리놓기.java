package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010_다리놓기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(combination(M,N)+ "\n");
		}
		System.out.println(sb);
	}
	public static long combination(int a, int b) {
		long temp1 = 1;
		long temp2 = 1;
		for (int i = 0; i < b; i++ ) {
			temp1 *= (a-i);
			if (temp1 % (b-i) == 0) {
				temp1 /= (b-i);
			} else {
				temp2 *= (b-i);
			}
		}
		return temp1/temp2;
	}
}
