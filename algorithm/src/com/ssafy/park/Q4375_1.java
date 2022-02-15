package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4375_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = null;
		while((str = br.readLine()) != null) {
			int num = Integer.parseInt(str);
			long temp = 1;
			int cnt = 1;
			while (true) {
				if (temp % num ==0) break;
				cnt ++;
				temp = (temp * 10 + 1) % num;
			}
			System.out.println(cnt);
		}
	}
}
