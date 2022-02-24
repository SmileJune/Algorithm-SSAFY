package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1934_최소공배수 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		for ( int tc = 1; tc <= n; tc++) {			
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
			sb.append((a*b/max)).append("\n");
		}
		System.out.println(sb);
	}
}
