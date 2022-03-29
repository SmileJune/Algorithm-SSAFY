package com.ssafy.yun.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1231 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuffer sb;
	public static char[] arr;
	public static int len;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuffer();
			sb.append("#").append(tc).append(" ");
			solution();
		}
	}

	static void solution() throws NumberFormatException, IOException {
		len = Integer.parseInt(br.readLine());
		arr = new char[len + 1];

		for (int i = 1; i <= len; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			char ch = st.nextToken().charAt(0);
			arr[idx] = ch;
		}

		check(1);
		System.out.println(sb);
	}

	static void check(int idx) {
		
		if(idx*2 <= len) {
			check(idx*2);			
		}
		
		sb.append(arr[idx]);
		
		if(idx*2+1 <= len) {
			check(idx*2+1);			
		}
	}

}
