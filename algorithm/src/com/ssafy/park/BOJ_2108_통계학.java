package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BOJ_2108_통계학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int sum = 0;
		int max = -4000;
		int min = 4000;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		double avg = (double) sum/N;
		if (avg >= 0) {
			avg = avg + 0.5;
		}
		else {
			avg = avg - 0.5;
		}
		sb.append((int)avg+ "\n");
		Arrays.sort(arr);
		sb.append(arr[arr.length/2] + "\n");
		int cnt = 0;
		List<Integer >cntarr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int temp = 1;
			for (int j = i + 1; j < N; j++) {
				if ( arr[i] == arr[j]) {
					temp++;
					i = j;
				} else break;
			}
			if (temp > cnt) {
				cntarr = new ArrayList<>();
				cntarr.add(arr[i]);	
				cnt = temp;
			}
			else if (temp == cnt) {
				cntarr.add(arr[i]);
			}
		}
		if (cntarr.size() >= 2) {
			sb.append(cntarr.get(1) + "\n");
		} else sb.append(cntarr.get(0) + "\n");
		sb.append(max-min);
		System.out.println(sb);
	}
}
