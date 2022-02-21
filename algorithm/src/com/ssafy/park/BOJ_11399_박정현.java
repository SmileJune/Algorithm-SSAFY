package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11399_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int no = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int[] arr = new int[no];
		int[] copy = new int[no];
		int max = 0;
		for (int i = 0; i < no ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}
		int[] cnt = new int[max+1];
		for (int i = 0; i < no; i++) {
			cnt[arr[i]]++;
		}
		for (int i = 1; i < cnt.length; i++) {
			cnt[i] += cnt[i-1];
		}
		for (int i = no-1; i >= 0; i--) {
			copy[cnt[arr[i]]-1] = arr[i];
			cnt[arr[i]]--;
		}
		int sum = copy[0];
		for (int i = 1; i < no; i++) {
			copy[i] += copy[i-1];
			sum += copy[i];
		}
		System.out.println(sum);
	}
}
