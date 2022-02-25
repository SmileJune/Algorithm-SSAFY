package com.ssafy.hwang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day18_BOJ_유클리드호제법 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		for(int i=0;i<gcd(A,B);i++) {
			sb.append("1");
		}
		System.out.println(sb);
		br.close();
	}
	public static long gcd(long a, long b) {
		if(a%b==0) return b;
		return gcd(b,a%b);
	}
}
