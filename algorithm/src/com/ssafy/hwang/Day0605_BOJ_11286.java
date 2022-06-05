package com.ssafy.hwang;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Day0605_BOJ_11286 {
	public static void main(String[] args) {
		inputData();
	}
	private static void inputData() {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		solution(N,sc);
		
	}
	private static void solution(int N, Scanner sc) {
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> minusPQ = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> plusPQ = new PriorityQueue<>();
		int num = 0 ;
		for(int i = 0 ; i <N;i++) {
			num = sc.nextInt();
			if(num>0) {
				plusPQ.add(num);
				continue;
			}
			if(num<0) {
				minusPQ.add(num);
				continue;
			}
			if(num == 0) {
				if(plusPQ.isEmpty() && minusPQ.isEmpty()) {
					sb.append("0\n");
					continue;
				}
				if(plusPQ.isEmpty()) {
					sb.append(minusPQ.poll()+"\n");
					continue;
				}
				if(minusPQ.isEmpty()) {
					sb.append(plusPQ.poll()+"\n");
					continue;
				}
				int comp1 = plusPQ.peek();
				int comp2 = - minusPQ.peek();
				if(comp1 >= comp2) {
					sb.append(minusPQ.poll()+"\n");
					continue;
				}
				if(comp1 < comp2) {
					sb.append(plusPQ.poll()+"\n");
					continue;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
