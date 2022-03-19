package com.ssafy.hwang;

import java.util.Scanner;

public class Day14_BOJ_10845_큐 {
	static int rear ;
	static int front ;
	static int[] queue;
	static int size;
	static StringBuilder sb ;
	public static void main(String[] args) {
		rear = 0;
		front = 0;
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		size = 10000;
		queue = new int[size];
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String op = sc.next();
			switch (op) {
			case "push"	 :	push(sc.nextInt()); break;
			case "front" :	front(); break;
			case "back"  :	back(); break;
			case "size"  :	sb.append(rear-front).append("\n"); break;
			case "empty" :	empty(); break;
			case "pop"   :	pop(); break;
			}
		}
		System.out.println(sb.toString());
		sc.close();
	}
	
	static int pop() {
		if(front == rear) { 
			sb.append(-1).append("\n");
			return -1;
		}
		sb.append(queue[++front]).append("\n");
		return queue[front];	
	}
	static int back() {
		if(front == rear) { 
			sb.append(-1).append("\n");
			return -1;
		}
		sb.append(queue[rear]).append("\n");
		return queue[rear];
	}	
	static int empty() {
		if(front == rear)  { 
			sb.append(1).append("\n");
			return 1;
		}
		sb.append(0).append("\n");
		return 0;
	}
	static int front() {
		if(front == rear)  { 
			sb.append(-1).append("\n");
			return -1;
		}
		sb.append(queue[front+1]).append("\n");
		return queue[front+1];
	}
	static boolean isFull() {
		if (front == (rear + 1) % size) return true;
		return false;
	}
	static void push(int i) {
		if (front == (rear + 1) % size) return;
		queue[++rear] = i;
	}
}
