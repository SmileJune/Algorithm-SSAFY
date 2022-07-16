package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Day160BOJ1269대칭차집합해쉬 { // 1269 대칭 차집합
	static int A, B;
	static HashMap<Integer, Integer> hashMap = new HashMap<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			hashMap.put(Integer.parseInt(st.nextToken()), i);
		}

		int dup = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < B; i++) {
			int key = Integer.parseInt(st.nextToken());
			if (hashMap.containsKey(key))
				dup++;
		}

		System.out.println(A + B - dup - dup);
	}

}
