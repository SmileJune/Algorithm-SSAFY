package com.ssafy.hwang;

import java.util.*;

public class Day73_BOJ_명령프롬프트 {
	static List<Long> list = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			list.clear();
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a%10==0) {
				System.out.println(10);
				continue;
			}
			cal(a,b);
		}
	}
	
	public static void cal(int a, int b) {
		long nowVal = a;
		while(!list.contains(nowVal%10)) {
			list.add(nowVal%10);
			nowVal = nowVal*a;
		}
		System.out.println(list.get((b%(list.size())+list.size()-1)%list.size()));
	}
}
