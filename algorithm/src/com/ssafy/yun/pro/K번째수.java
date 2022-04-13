package com.ssafy.yun.pro;

import java.util.Arrays;

public class K번째수 {
	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		System.out.println(Arrays.toString(solution(array,commands)));
	}

	static public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int arrLength = commands[i][1] - commands[i][0] + 1;
			int[] arrExtract = new int[arrLength];
			System.arraycopy(array, commands[i][0] - 1, arrExtract, 0, arrLength);

			Arrays.sort(arrExtract);

			answer[i] = arrExtract[commands[i][2] - 1];
		}
		return answer;
	}
}
