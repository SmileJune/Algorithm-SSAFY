package com.ssafy.an.day049;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Day20SW4789공연박수알바 { // 4789
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/an/input4789.txt")));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int cnt = 0;
			char[] arr = br.readLine().toCharArray();
			int clap = arr[0] - '0'; // 0명일때 기립박수를 하고 있는 사람의 수

			if (arr.length != 1) {
				for (int i = 1; i < arr.length; i++) {
					int n = arr[i] - '0';
					if (n != 0) {						
						if (clap < i) { // 앞에 까지 박수치는 사람이 원하는 사람수보다 적었다면,
							cnt += i - clap; // 고용 추가
							clap += n + i - clap; // 갱신
						} else {
							clap += n; // 필요한 인원보다 이미 많이 치고 있었으면 그대로 추가
						}
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}
