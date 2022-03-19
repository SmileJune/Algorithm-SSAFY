package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9012_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int no = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= no; tc++) {
			String str = br.readLine();
			int temp = 0;
			String result = "YES";
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					temp++;
				} else {
					temp--;
					if (temp < 0) {
						break;
					}
				}
			}
			if (temp != 0)
				result = "NO";
			sb.append(result).append("\n");
		}
		System.out.println(sb);

	}
}
