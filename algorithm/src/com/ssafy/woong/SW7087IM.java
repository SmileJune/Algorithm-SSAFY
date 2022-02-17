package com.ssafy.woong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW7087IM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			System.out.printf("#%d %d\n",i,solution());
		}
	}
	
	static int solution() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		boolean[] check = new boolean[26];
		for(int i = 0 ; i < n ; i++) {
			check[br.readLine().charAt(0) - 'A'] = true;
		}
		
		for(int i = 0 ; i < 26; i++) {
			if(!check[i]) {
				return i;
			}
		}
		return 26;
		
		
	}
}