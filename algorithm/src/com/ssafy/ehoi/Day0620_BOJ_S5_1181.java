package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Day0620_BOJ_S5_1181 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		} // 입력 끝
		
		// 이제 정렬시작
		// 조건 : 길이 짧은 순 -> 길이가 같다면 사전 순
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}
			}
		});
		
		// 출력 : 같은 단어는 한번만 출력되도록
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]).append("\n");
		for (int i = 1; i < N; i++) {
			
			if(!arr[i].equals(arr[i-1])) {
				sb.append(arr[i]).append("\n");
			}
		}
		System.out.println(sb);
	}
}
