package com.ssafy.yun.pro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 1, 2, 3, 4, 5 })));
	}

	public static int[] solution(int[] answers) {
		int[] person0 = { 1, 2, 3, 4, 5 };
		int[] person1 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] person2 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int[] num = new int[3];
		num[0] = checkAnswers(person0, answers);
		num[1] = checkAnswers(person1, answers);
		num[2] = checkAnswers(person2, answers);

		int max = Math.max(Math.max(num[0], num[1]), num[2]);

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < num.length; i++) {
			if (num[i] == max) {
				list.add(i + 1);
			}
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer; // list.toArray(new Integer[list.size()]) 하고 wrapper타입을 다 풀어주려면...?

	}

	public static int checkAnswers(int[] person, int[] answers) {
		int cnt = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == person[i % person.length]) {
				cnt++;
			}
		}
		return cnt;
	}
}
