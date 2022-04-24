package com.ssafy.yun.pro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 더맵게 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7));
	}

	public static int solution(int[] scoville, int K) {

		List<Integer> list = new ArrayList<>();
		setList(scoville, list);
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		int numberOfAttempts = 0;

		while (true) {
			int lastElement = list.size() - 1;

			if (list.get(lastElement) >= K) {
				return numberOfAttempts;
			}

			if (list.size() == 1) {
				return -1;
			}

			int mixedFood = list.get(lastElement) + list.get(lastElement - 1) * 2;
			list.remove(lastElement);
			list.remove(lastElement - 1);
			list.add(mixedFood);
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			numberOfAttempts++;

		}
	}

	private static void setList(int[] scoville, List<Integer> list) {
		for (int i = 0; i < scoville.length; i++) {
			list.add(scoville[i]);
		}
	}
}
