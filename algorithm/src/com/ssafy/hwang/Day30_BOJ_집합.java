package com.ssafy.hwang;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day30_BOJ_집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String a = sc.next();

			switch (a) {
			case "add":
				set.add(sc.nextInt());
				break;
			case "check":
				if(set.contains(sc.nextInt())) {
					sb.append(1+"\n");
				}else {
					sb.append(0+"\n");
				}break;
			case "remove":
				set.remove(sc.nextInt());
				break;
			case "toggle":
				int s = sc.nextInt();
				if(set.contains(s)) {
					set.remove(s);
				}else {
					set.add(s);
				}break;
			case "all":
				for(int j = 1 ; j <= 20;j++) {
					set.add(j);
				}break;
			case "empty":
				set.clear();
				break;
			}

		}
		System.out.println(sb.toString());
	}
}
