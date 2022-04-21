package com.ssafy.ehoi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 큐
public class Day73_BOJ_S4_10845 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		int T = sc.nextInt();
		int rear = -1;
		for (int i = 0; i < T; i++) {
			String comm = sc.next();
			switch(comm) {
			case "push" :
				rear = sc.nextInt();
				q.add(rear);
				break;
			case "pop" :
				sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
				break;
			case "size" :
				sb.append(q.size()).append("\n");
				break;
			case "empty" :
				sb.append(q.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front" :
				sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
				break;
			case "back" :
				sb.append(q.isEmpty() ? -1 : rear).append("\n");
				break;
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
