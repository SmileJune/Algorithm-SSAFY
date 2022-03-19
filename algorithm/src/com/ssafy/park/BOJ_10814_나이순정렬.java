package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String[][] arr = new String[N][2];
		int[] age = new int[201];
		for ( int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
			age[Integer.parseInt(arr[i][0])]++;
		}
		for (int i = 1; i < age.length; i++) {
			age[i] += age[i-1];
		}
		String[][] arrcopy = new String[N+1][2];
		for (int i = N -1; i >=0 ; i--) {
			arrcopy[age[Integer.parseInt(arr[i][0])]][0] = (arr[i][0]);
			arrcopy[age[Integer.parseInt(arr[i][0])]][1] = (arr[i][1]);
			age[Integer.parseInt(arr[i][0])]--;
		}
		for (int i = 1; i <= N; i++) {
			sb.append(arrcopy[i][0] + " " + arrcopy[i][1] + "\n");
		}
		System.out.println(sb);
	}
}
