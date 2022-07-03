package com.ssafy.hwang;

import java.util.*;

public class Day0703_BOJ1755 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//알파벳 정렬
		// 8 5 4 9 1 7 6 3 2 0
		// a b c d e f g h i j
		String s = "jeihcbgfad";
		HashMap<String,Integer> map = new HashMap<>();
		String tmp = "";
		int N = sc.nextInt(); // 시작 숫자
		int M = sc.nextInt(); // 끝 숫자
		for(int i = N ; i<=M;i++) {
			if(i<10) { // 한 자리 숫자일 때
				map.put(s.charAt(i)+"", i);
			}else {
				tmp = s.charAt(i/10)+""+s.charAt(i%10);
				map.put(tmp, i);
			}
		}
		Object[] tmpArr = map.keySet().stream().sorted().toArray();
		
		int cnt = 0 ;
		for(Object o : tmpArr) {
			cnt++;
			System.out.print(map.get(o)+" ");
			if(cnt%10==0) System.out.println();
		}
	}
}
