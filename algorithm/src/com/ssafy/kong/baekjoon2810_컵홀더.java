package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class baekjoon2810_컵홀더{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		char[] chair = br.readLine().toCharArray();
		int cup = 1;
		for(int i = 0; i < chair.length; ++i) {
			if(chair[i] == 'S') {
				cup+=1;
			}
			if( chair[i] == 'L') {
				cup+=1;
				i++;
			}
			
		}
		if(cup > n)
			System.out.println(n);
		else System.out.println(cup);
	}
}