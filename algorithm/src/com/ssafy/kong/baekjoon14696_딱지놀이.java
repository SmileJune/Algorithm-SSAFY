package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon14696_딱지놀이 {
	static int[] countA;
	static int[] countB;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 1; t <= T; ++t) {
			countA = new int[5];
			countB = new int[5];
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int[] A = new int[n1];	
			for(int i = 0; i < n1; ++i) {
				A[i] = Integer.parseInt(st.nextToken());
				countA[A[i]]++;
			}
			st = new StringTokenizer(br.readLine());
			int n2 = Integer.parseInt(st.nextToken());
			int[] B = new int[n2];
			for(int i = 0; i < n2; ++i) {
				B[i] = Integer.parseInt(st.nextToken());
				countB[B[i]]++;
			}
			whoWin(4);
		}
	}
	static void whoWin(int i) {
		if( countA[i] > countB[i] ) {
			System.out.println("A");
			return;
		}else if(countA[i] < countB[i]){
			System.out.println("B");
			return;
		}else {	//같으면
			if(i != 1)
				whoWin(i-1);
			else {
				System.out.println("D");
			}
		}
	}
}