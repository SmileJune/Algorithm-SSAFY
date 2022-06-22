package com.ssafy.an.day149;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Day136BOJ10867중복빼고정렬하기SET {
	static int N;
	static HashSet<Integer> set;
	static ArrayList<Integer> arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		set = new HashSet<>();
		for (int i = 0; i < N; i++)
			set.add(Integer.parseInt(st.nextToken()));
		arr = new ArrayList<>(set);
		Collections.sort(arr);
		System.out.println(arr.toString().replaceAll("[\\[\\],]", ""));
		br.close();
	}
}
