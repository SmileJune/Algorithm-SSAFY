package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2999_비밀이메일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int R = 0;
		int C = 0;
		for(int i = str.length; i >= 1; --i) {
			for(int j = i; j >= 1; --j) {
				if( i * j == str.length ) {
					R = Math.max(R, j);
				}
			}
		}
		C = str.length/R;
		char[][] deco = new char[C][R];
		for(int i = 0; i < C; ++i) {
			for(int j = 0; j < R; ++j) {
				deco[i][j] = str[j+R*i];
			}
		}
		for(int i = 0; i < R; ++i) {
			for(int j = 0; j < C; ++j) {
				System.out.print(deco[j][i]);
			}
		}
	}
}