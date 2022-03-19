package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon8958_OX퀴즈{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; ++t) {
			char[] OX = br.readLine().toCharArray();
			int score = 0;
			int seq = 0;
			for(int i = 0; i < OX.length; ++i) {
				if( OX[i] == 'X') 
					seq = 0;
				else
					++seq;
				score += seq;
			}
			System.out.println(score);
		}
	}
}
