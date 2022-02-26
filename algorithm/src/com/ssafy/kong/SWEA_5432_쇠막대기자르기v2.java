package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class SWEA_5432_쇠막대기자르기v2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			String input = br.readLine();
			String re = input.replace("()", "-");
			int iron = 0;
			int ans = 0;
			for(int i =0 ;i < re.length(); ++i) {
				if(re.charAt(i) == '-') ans += iron;
				else if (re.charAt(i) == '(') {
					iron++;
					ans++;
				}else if(re.charAt(i) == ')') {
					iron--;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}