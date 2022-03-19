package com.ssafy.woong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298_2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[n];
		
		
		
		for(int i = 0 ; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			ans[i] = -1;
		}
		
		for(int i = 0; i < n - 1; i++) {
			while(!stack.isEmpty() && stack.peek() < arr[i+1]) {
				sb.append(arr[i + 1]).append(" ");
			}
			
			if(arr[i] < arr[i+1]) {
				sb.append(arr[i + 1]).append(" ");
			}
			else {
				stack.add(arr[i]);
			}
			
		}
		sb.append("-1");
		bw.write(sb.toString());
		bw.flush();
		
	}

}

/*
A B C D
	D 

if B > D  -> B는 A의 오큰수 후보
   B < C  -> C는 B의  오큰수
  C < B < D -> B의 오큰수는 C의 오큰수
*/