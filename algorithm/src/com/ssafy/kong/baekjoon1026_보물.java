package com.ssafy.kong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon1026_보물 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; ++i) { 	// 배열 A 채우기
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; ++i) {	// 배열 B 채우기
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int tmp = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = i+1; j < N; ++j) {
				if(A[i] > A[j]) {
					tmp = A[i];
					A[i] = A[j];
					A[j] = tmp;
				}
				if(B[i] < B[j]) {
					tmp = B[i];
					B[i] = B[j];
					B[j] = tmp;
				}
			}
		}
		int sum = 0;
		for(int i = 0; i < N; ++i) {
			sum += A[i] * B[i];
		}
		System.out.println(sum);
	}
}
