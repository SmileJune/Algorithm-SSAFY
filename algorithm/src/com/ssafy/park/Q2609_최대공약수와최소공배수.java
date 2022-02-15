package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2609_최대공약수와최소공배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int temp = 0;
		if ( a < b) {
			temp = a;
			a = b;
			b = temp;
		}
		int max = 0;
		for (int i = b; i > 0; i--) {
			if ( b % i == 0 && a %i == 0) {
				max = i;
				break;
			}
		}
		System.out.println(max);
		System.out.println((a*b/max));
	}
}
