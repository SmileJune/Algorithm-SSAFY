package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baek_17413 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		StringBuffer sb = new StringBuffer();
		int flag = 0;

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '<') {
				bw.write(sb.reverse().toString());
				sb = new StringBuffer();
				flag = 1;
				bw.write('<');
				continue;
			}
			if (ch == '>') {
				flag = 0;
				bw.write('>');
				continue;
			}

			if (flag == 1) {
				bw.write(ch);
				continue;
			}

			if (ch == ' ') {
				bw.write(sb.reverse().toString());
				bw.write(' ');
				sb = new StringBuffer();
				continue;
			}

			sb.append(ch);
		}
		bw.write(sb.reverse().toString());

		bw.close();
	}

}
