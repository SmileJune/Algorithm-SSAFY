package com.ssafy.woong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B17298 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		int[] ans = new int[n];
		
		
		
		for(int i = 0 ; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			ans[i] = -1;
		}
		
		for(int i = n-2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				ans[i] = arr[i+1];
			}
			else {
				for(int j = i; j < n-1 ;j++) {
					if(arr[i] < ans[j + 1]) {
						ans[i] = ans[j+1];
						break;
					}
				}
			}
			
		}
		for(int i = 0 ; i < n- 1; i++) {
			sb.append(ans[i]).append(" ");
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