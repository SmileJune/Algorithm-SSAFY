package com.ssafy.hwang;

import java.util.Map.Entry;
import java.util.*;

public class Day0703_BOJ1302 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int maxCnt = 1;
		HashMap<String,Integer> map = new HashMap<>();
		for(int i = 0 ; i <N;i++) {
			String s = sc.next();
				map.put(s, map.getOrDefault(s, 0)+1);
				maxCnt = Math.max(maxCnt, map.get(s));
		}
		ArrayList<String> list = new ArrayList<>();
		for(Entry<String, Integer> e : map.entrySet()) {
			if(e.getValue() == maxCnt) {
				list.add(e.getKey());
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}
}
