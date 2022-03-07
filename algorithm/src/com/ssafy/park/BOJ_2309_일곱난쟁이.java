package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2309_일곱난쟁이 {
	public static void main(String[] args) throws IOException{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = 9;
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		sum =  sum - 100;
		for (int i = 0; i < N-1; i++) {
			int temp = 0;
			for (int j = i+1; j < N; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		int idx1 = 0;
		int idx2 = 0;
		outer : for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				if (arr[i] + arr[j] == sum) {
					idx1 = i;
					idx2 = j;
					break outer;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (i != idx1 && i != idx2) {
				sb.append(arr[i] + "\n");
			}
		}

		System.out.println(sb);
	}
	
}
