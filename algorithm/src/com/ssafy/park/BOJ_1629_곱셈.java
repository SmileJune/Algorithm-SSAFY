package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {
public static long C;
	
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());	
		System.out.println(pow(A, B));
	}
	public static long pow(long A, long e) {
		if(e == 1) {
			return A % C;
		}
		long temp = pow(A, e / 2);
		
		if(e % 2 == 1) {
			return (temp * temp % C) * A % C;
		}
		return temp * temp % C;	
	}
}