package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon10845_큐 {
	static StringBuilder sb = new StringBuilder();
	static int length = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =  Integer.parseInt(br.readLine());
		int[] list = new int[n];
		for(int i = 0; i < n; ++i) {
			doStack(br.readLine().split(" "), list);
		}
		System.out.print(sb);
	}

	static void doStack(String[] stack, int[] list) {
		switch(stack[0]) {
		case "push":
			list[length++] = Integer.parseInt(stack[1]);
			break;
		case "pop":
			if( length > 0 ) {
				sb.append(list[0]).append("\n");
				for(int i = 0; i < length-1; ++i) {
					list[i] = list[i+1];
				}
				length--;
				}
			else	
				sb.append(-1).append("\n");
			break;
		case "size":
			sb.append(length).append("\n");
			break;
		case "empty":
			if(length == 0) 	
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
			break;
		case "front":
			if( length > 0 )		
				sb.append(list[0]).append("\n");
			else	
				sb.append(-1).append("\n");
			break;
		case "back":
			if( length > 0 )		
				sb.append(list[length-1]).append("\n");
			else	
				sb.append(-1).append("\n");
			break;
		}
	}
}

