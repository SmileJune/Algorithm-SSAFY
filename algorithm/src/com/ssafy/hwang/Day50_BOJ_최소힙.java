package com.ssafy.hwang;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Day50_BOJ_최소힙 {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 0; tc< t ; tc++) {
			int x = sc.nextInt();
			if(x>0) {
				queue.add(x);
			}else {
				if(queue.isEmpty()) {
					sb.append(0+"\n");
					continue;
				}
				sb.append(queue.poll()+"\n");
			}
			
			
			
			
		}
		System.out.println(sb.toString());
	}
}
