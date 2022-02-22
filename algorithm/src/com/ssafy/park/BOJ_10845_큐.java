package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10845_큐 {
	static int[] arr;
	static int front;
	static int rear;
	static int no;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		no = Integer.parseInt(br.readLine());
		arr = new int[no];
		front = 0;
		rear = 0;
		for (int n = 0; n < no; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String str = st.nextToken();
			if (str.equals("push")) push(Integer.parseInt(st.nextToken()));
			else if (str.equals("pop")) pop();
			else if (str.equals("size")) size();
			else if (str.equals("empty")) empty();
			else if (str.equals("front")) front();
			else if (str.equals("back")) back();
		}
	}
	public static void push(int num) {
		rear = (rear + 1) % no;
		arr[rear] = num;
	}
	
	public static void pop() {
		if (front == rear) System.out.println(-1);
		else {			
			front = (front + 1) % no;
			System.out.println(arr[front]);
		}
	}
	public static void size() {
		System.out.println(rear-front);
	}
	public static void empty() {
		if (front == rear) System.out.println(1);
		else System.out.println(0);
	}
	public static void front() {
		if (front == rear) System.out.println(-1);
		else {
			System.out.println(arr[(front+1) % no]);
		}
	}
	public static void back() {
		if (front == rear) System.out.println(-1);
		else {
			System.out.println(arr[rear]);
		}
	}
}
