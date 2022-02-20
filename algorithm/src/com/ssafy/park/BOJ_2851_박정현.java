package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2851_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int num = 0;
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			if (Math.abs(100-num) >= Math.abs(100-num-n)) {
				num += n;
			} else break;
		}
		sb.append(num);
		System.out.println(sb);
	}
}
