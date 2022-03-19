package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16917_양념반후라이드반 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int Z = 0;
		if (A+B > 2*C) {
			Z = 2*Math.min(X, Y);
			X -= Z/2;
			Y -= Z/2;
		}
		int sum = Z*C;
		if (A > 2*C) {
			sum += X*2*C;
		} else sum += X*A;
		if (B > 2*C) {
			sum += Y*2*C;
		} else sum += B*Y;
		System.out.println(sum);
	}
}
