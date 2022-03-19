package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2810_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int sum = 1;
		for (int i = 0; i <str.length(); i++) {
			if (str.charAt(i) == 'L') i++;
			sum++;
		}
		if (str.length() <= sum) System.out.println(str.length());
		else System.out.println(sum);
	}
}
