package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_11720_undefined {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		for (int i = 0; i < str.length(); i++) {
			bw.write(check(str.charAt(i)));
		}

		bw.close();
	}

	public static char check(char c) {
		if('a'<=c && c<='z') {
			int ch = c+13;
			if(ch>'z') {
				ch-=('z'-'a'+1);
			}
			return (char)ch;
		}
		if('A'<=c && c<='Z') {
			int ch = c+13;
			if(ch>'Z') {
				ch-=('Z'-'A'+1);
			}
			return (char)ch;
		}
		
		return c;
	}

}
