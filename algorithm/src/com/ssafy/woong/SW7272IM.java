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
			System.out.printf("#%d %s\n",i,solution());
		}
	}
	
	static String solution() throws NumberFormatException, IOException {
		
		String[] group = {"B","CEFGHIJKLMNSTUVWXYZ","ADOPQR"};
		st = new StringTokenizer(br.readLine());
		
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		
		if(s1.length() == s2.length()) {
			
			outer: for(int i = 0; i < s1.length(); i++) {
				for(int j = 0; j < 3; j++) {
					if(group[j].contains(String.valueOf(s1.charAt(i))) && group[j].contains(String.valueOf(s2.charAt(i)))){
						continue outer;
					}
				}
				return "DIFF";
			}
		return "SAME";
		}return "DIFF";
		
		
	}
}