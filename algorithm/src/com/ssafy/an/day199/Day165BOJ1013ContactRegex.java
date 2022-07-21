package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Day165BOJ1013ContactRegex {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		Pattern pattern = Pattern.compile("^(100+1+|01)+$");
		for (int i = 0; i < t; i++) {
			if (pattern.matcher(br.readLine()).matches()) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.print(sb);
		br.close();
	}
}
