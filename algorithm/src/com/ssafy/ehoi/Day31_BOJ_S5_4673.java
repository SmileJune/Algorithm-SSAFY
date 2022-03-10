package com.ssafy.ehoi;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Day31_BOJ_S5_4673 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] a = new boolean[10001];

//		int value = 0;
		for (int i = 1; i <= 10000; i++) {
			if (d(i) <= 10000) // 10000이하까지만 배열에 들어갈 거니까
			a[d(i)] = true; // 값이 나오면 그 배열을 true로 바꿈
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 10000; i++) { // 배열 돌면서
			if(a[i] == false) { // false라면 값이 나온적이 없다! == 셀프넘버다!
				sb.append(i).append('\n');
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	public static int d(int number) {
		int value = number;
		
		String tmp = "" + value;
		for (int i = 0; i < tmp.length(); i++) {
			value += tmp.charAt(i) - '0';
		}
		
		return value;
	}
}
