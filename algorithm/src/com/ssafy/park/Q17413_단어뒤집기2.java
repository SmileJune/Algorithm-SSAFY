package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17413_단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		char[] carr = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			carr[i] = str.charAt(i);
		}
		int trig = 0;
		int idx = 0;
		char[] c = new char[carr.length];
		for (int i = 0; i <= carr.length - 1; i++) {
			c[i] = carr[i];
			if ( carr[i] == '<') {
				trig = 1;
				if (i > 0 && carr[i-1] != '>') {
					char temp;
					for (int j=0; j+idx < (i-idx)/2+idx; j++) {
						temp = c[j+idx];
						c[j+idx] = c[i-1-j];
						c[i-1-j] = temp;
					} idx= (i +1);
				}
			}
			if (trig ==0 && carr[i] == ' ') {
				char temp;
				for (int j=0; j+idx < (i-idx)/2+idx; j++) {
					temp = c[j+idx];
					c[j+idx] = c[i-1-j];
					c[i-1-j] = temp;
				} idx = (i+1);
			}
			if (i == c.length-1 && c[i] != '>') {
				char temp;
				for (int j=0; j+idx < (i-idx+1)/2+idx; j++) {
					temp = c[j+idx];
					c[j+idx] = c[i-j];
					c[i-j] = temp;
				}
			}
			if (carr[i] == '>') {
				trig = 0;
				idx = (i + 1);
			}
			
		}
		for (int i = 0; i < c.length; i++) {
			sb.append(c[i]);
		}

		System.out.println(sb);
	}
}
