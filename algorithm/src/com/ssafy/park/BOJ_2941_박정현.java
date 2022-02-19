package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char[] arr= new char[str.length()];
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ( c == 'c') {
				if ( i+1 < str.length() && (str.charAt(i+1) == '=' || str.charAt(i+1) == '-')) i++;		
			}
			else if (c == 'd') {
				if (i + 1 < str.length()) {
					if ( str.charAt(i+1) == 'z' && i+2 < str.length() && str.charAt(i+2) == '=') i+=2;
					else if (str.charAt(i+1) == '-') i++;
				}
			}
			else if ( (c == 'l' || c == 'n') && i+1 < str.length() && str.charAt(i+1) == 'j') i++;
			else if ( (c == 's' || c == 'z') && i+1 < str.length() && str.charAt(i+1) == '=') i++;
			count++;
		}
		System.out.println(count);
	}
}
