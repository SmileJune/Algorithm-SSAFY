package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baek_17298 { //시간초과

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;

	static int[] arr;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < arr.length; i++) {
			bw.write(solution(i)+" ");
		}
		bw.close();
	}
		

	static int solution(int idx) {
		int pivotNumber = arr[idx];
		for (int i = idx + 1; i < arr.length; i++) {
			if (arr[i] > pivotNumber) {
				return arr[i];
			}
		}
		return -1;
	}
}
