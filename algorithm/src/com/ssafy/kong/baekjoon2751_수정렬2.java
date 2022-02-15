package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baekjoon2751_수정렬2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		ArrayList<Integer> num = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < n; ++i) {
			num.add(i,Integer.parseInt(br.readLine()));
		}
		Collections.sort(num);
		for(int i : num) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

}
