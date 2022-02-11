package com.ssafy.yun;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_1966 {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) { // 우선순위 큐도 따로 배워보자!
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.println(solution());
		}

	}

	public static int solution() {
		int totalNumber = sc.nextInt();
		int targetIndex = sc.nextInt();

		Queue<Ball> q = new LinkedList<>();
		int[] priorityArr = new int[totalNumber];

		for (int i = 0; i < totalNumber; i++) {
			int priority = sc.nextInt();
			q.add(new Ball(i, priority));
			priorityArr[i] = priority;
		}

		Arrays.sort(priorityArr);

		for (int i = priorityArr.length - 1; i >= 0; i--) {
			while (true) {
				Ball ball = q.poll();
				if (ball.priority != priorityArr[i]) {
					q.add(ball);
					continue;
				}

				if (ball.idx == targetIndex) {
					return priorityArr.length - i;
				}

				break;
			}
		}

		return 0;
	}

}

class Ball {
	int idx;
	int priority;

	public Ball(int idx, int priority) {
		super();
		this.idx = idx;
		this.priority = priority;
	}
}
