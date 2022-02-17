package com.ssafy.woong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW7272IM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			System.out.printf("#%d %d\n",i,solution());
		}
	}
	
	static int solution() throws NumberFormatException, IOException {
		
		String set1 = "CEFGHIJKLMNSTUVWXYZ";
		String set2 = "ADOPQR";
		
		st = new StringTokenizer(br.readLine());
		
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		
		for(int i = 0 ; i < s1.length(); i++) {
			if(set1.contains(s1.substring(0, i+1))) {
				s1.replace("")
			}
		}
		
		for(int i = 0 ; i < 26; i++) {
			if(!check[i]) {
				return i;
			}
		}
		return 26;
		
		
	}
}