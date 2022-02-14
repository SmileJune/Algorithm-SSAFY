package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon1181_단어정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		for(int i = 0; i < N; ++i) {
			str[i] = br.readLine();
		}
		String tmp = "";
		for(int i = 0; i < N; ++i) {
			for(int j = i+1; j < N; ++j) {
				if( str[i].length() > str[j].length() ) {
					tmp = str[i];
					str[i] = str[j];
					str[j] = tmp;
				}else if( str[i].length() == str[j].length() ) {
					if( str[i].compareTo(str[j]) > 0 ) {
						tmp = str[i];
						str[i] = str[j];
						str[j] = tmp;
					}
				}
			}
		}
		sb.append(str[0]).append("\n");
		for(int i = 1; i < N; ++i) {
			if(!str[i].equals(str[i-1]))
				sb.append(str[i]).append("\n");
		}
		System.out.println(sb);
	}

}
