package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_21921_박성현 {
	// 원형 큐로 푸는 문제 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		int N = sc.nextInt();
		int X = sc.nextInt();
		int[] visitor = new int[N];
		
		for (int i = 0; i < N; i++)
			visitor[i] = sc.nextInt();
		
		
		Queue q = new Queue();
		q.newQ(X + 1);
		for (int i = 0; i < X; i++)
			q.enQ(visitor[i]);
		int max = q.sum;
		int cnt = 1;
		
		for (int i = X; i < N; i++) {
			q.deQ();
			q.enQ(visitor[i]);
			int sum = q.sum;
			
			if (max == sum)
				cnt++;
			else if (max < sum) {
				max = sum;
				cnt = 1;
			}
		}
		if (max == 0) {
			System.out.println("SAD");
			return;
		}
		System.out.println(max);
		System.out.println(cnt);
	}	
}

class Queue {
	int front;
	int rear;
	int Qsize;
	int[] QArr;
	int sum;
	void newQ(int Qsize) {
		front = 0;
		rear = 0;
		this.Qsize = Qsize;
		QArr = new int[Qsize];
	}
	boolean isFull() {
		if (((rear + 1) % this.Qsize)== front) 
			return true;
		
		else 
			return false;
	}
	
	boolean isEmpty() {
		return rear == front;
	}
	void enQ(int num) {
		if (isFull()) 
			return;
		
		else {
			rear = (++rear) % this.Qsize;
			QArr[rear] = num;
			sum += num;
		}
	}
	
	int deQ() {
		if (isEmpty())
			return -1;
		else {
			front = (++front) % this.Qsize;
			sum -= QArr[front];
			QArr[front] = 0;
			return QArr[front];
		}
	}
}