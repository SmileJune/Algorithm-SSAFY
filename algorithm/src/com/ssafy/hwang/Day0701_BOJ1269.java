package com.ssafy.hwang;

import java.util.*;

public class Day0701_BOJ1269 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		HashSet<Integer> set1 = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();
		HashSet<Integer> addAll = new HashSet<>();
		int N = sc.nextInt();
		int M = sc.nextInt();
		int tmp = 0 ;
		for (int i = 0; i < N; i++) {
			tmp = sc.nextInt();
			set1.add(tmp);
			addAll.add(tmp);
		}
		for ( int i = 0 ; i < M; i ++) {
			tmp = sc.nextInt();
			set2.add(tmp);
			addAll.add(tmp);
		}
		set1.retainAll(set2);
		System.out.println(addAll.size()-set1.size());
	}
}
