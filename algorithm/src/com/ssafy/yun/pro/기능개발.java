package com.ssafy.yun.pro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기능개발 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 })));
	}

	public static int[] solution(int[] progresses, int[] speeds) {

		int[] daysToComplete = new int[progresses.length];
		setDaysToComplete(progresses, speeds, daysToComplete);

		List<Integer> answerList = new ArrayList<>();
		int pivotNumber = daysToComplete[0];
		int count = 0;

		setAnswerList(daysToComplete, answerList, pivotNumber, count);

		Integer[] integerAnswer = answerList.toArray(new Integer[0]);

		int[] answer = new int[integerAnswer.length];
		setAnswer(integerAnswer, answer);

		return answer;
	}

	private static void setAnswer(Integer[] integerAnswer, int[] answer) {
		for (int i = 0; i < integerAnswer.length; i++) {
			answer[i] = integerAnswer[i];
		}
	}

	private static void setAnswerList(int[] daysToComplete, List answerList, int pivotNumber, int cnt) {
		for (int i = 0; i < daysToComplete.length; i++) {
			if (daysToComplete[i] <= pivotNumber) {
				cnt++;

				isLastElement(daysToComplete, answerList, cnt, i);
				continue;
			}
			answerList.add(cnt);
			pivotNumber = daysToComplete[i];
			cnt = 1;

			isLastElement(daysToComplete, answerList, cnt, i);
		}
	}

	private static void setDaysToComplete(int[] progresses, int[] speeds, int[] daysToComplete) {
		for (int i = 0; i < progresses.length; i++) {
			daysToComplete[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
		}
	}

	private static void isLastElement(int[] daysToComplete, List answerList, int cnt, int i) {
		if (i == daysToComplete.length - 1) {
			answerList.add(cnt);
		}
	}
}
