package com.ssafy.yun.pro;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프린터 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 19, 1, 1, 1 }, 0));
	}

	public static int solution(int[] priorities, int location) {
		Queue<Ball> queue = new LinkedList<>();
		setQueue(priorities, queue);

		Arrays.sort(priorities);

		int step = 1;
		while (!queue.isEmpty()) {
			if (isTopPriority(queue.peek().priority, priorities[priorities.length - step])) {
				Ball ball = queue.poll();
				if (isWhatIWantToPrint(location, ball)) {
					return step;
				}
				step++;
				continue;
			}
			queue.add(queue.poll());
		}

		return -1;
	}

	private static boolean isWhatIWantToPrint(int location, Ball ball) {
		return ball.location == location;
	}

	private static boolean isTopPriority(int priority, int priority2) {
		return priority == priority2;
	}

	private static void setQueue(int[] priorities, Queue<Ball> queue) {
		for (int i = 0; i < priorities.length; i++) {
			queue.offer(new Ball(i, priorities[i]));
		}
	}

	static class Ball {
		int location;
		int priority;

		Ball(int location, int priority) {
			this.location = location;
			this.priority = priority;
		}
	}
}
