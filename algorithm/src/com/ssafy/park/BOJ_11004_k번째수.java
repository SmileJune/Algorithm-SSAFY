package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11004_k번째수 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		for (int i=0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken()); 
		}
		
		for (int i = 0; i < K; i++) {
			int temp = 0;
			for (int j = i+1; j <N; j++) {
				if ( arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] =  arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(arr[K-1]);
		
	}
}
