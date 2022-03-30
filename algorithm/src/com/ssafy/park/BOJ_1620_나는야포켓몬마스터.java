package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620_나는야포켓몬마스터 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		String[] arr = new String[N+1];
		for (int i = 1; i <= N; i++) {
			String name = br.readLine();
			map.put(name, i);
			arr[i] = name;
		}
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (str.charAt(0) - '0' > 9) {
				sb.append(map.get(str) + "\n");
			} else {
				int a = Integer.parseInt(str);
				sb.append(arr[a] + "\n");
			}
		}
		System.out.println(sb);
	}
}
