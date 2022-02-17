package com.ssafy.woong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW7964IM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String[] cityArr = new String[300002];
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d\n",tc, solution());
		}
		
	}
	
	static int solution() throws IOException {
		int gateNum = 0;
		st = new StringTokenizer(br.readLine());
		int cityNum = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		String[] cityArr = br.readLine().split(" ");
		
		int idx = 0;
		int lim = -1 + d;
		boolean flag = true;
		
		for(int i = 0 ; i < cityArr.length; i++) {
			if(cityArr[i].equals("1")) {
				lim = d;
			}
			else {
				lim--;
				if(lim <= 0) {
					gateNum++;
					lim = d;
				}
			}
		}
		
		return gateNum;
	}
}

