package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon2941_크로아티아{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int ans = 0;
		for(int i = 0; i < str.length; ++i) {
			if( i+2 < str.length && str[i] == 'd' && str[i+1] == 'z' && str[i+2] == '=') {
				i+=2;
				ans++;
				continue;
			}
			if( i+1 < str.length ) {
				if( str[i] == 'c' && ( str[i+1] == '=' || str[i+1] == '-') ) {
					i++;
					ans++;
					continue;
				}
				if( str[i+1] == '=' && (str[i] =='s' || str[i] =='z')) {
					i++;
					ans++;
					continue;
				}
				if( str[i] == 'd' && str[i+1] == '-') {
					i++;
					ans++;
					continue;
				}
				if( str[i+1] =='j' && (str[i] =='l' || str[i] == 'n')) {
					i++;
					ans++;
					continue;
				}
			}
			ans++;
		}
		System.out.println(ans);
	}
}