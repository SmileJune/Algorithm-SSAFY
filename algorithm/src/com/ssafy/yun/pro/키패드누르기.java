package com.ssafy.yun.pro;

public class 키패드누르기 {
	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";
		System.out.println(solution(numbers, hand));
	}

	public static String solution(int[] numbers, String hand) {

		int k = 1;
		int la = 3, lb = 0, ra = 3, rb = 2;
		int a, b;
		StringBuffer sb = new StringBuffer();

		int[][] dial = new int[4][3];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < dial[i].length; j++) {
				dial[i][j] = k;
				k++;
			}
		}
		dial[3][0] = 77;
		dial[3][1] = 0;
		dial[3][2] = 99;

		for (int number : numbers) {
			if (number == 1 || number == 4 || number == 7) {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 3; j++) {
						if (dial[i][j] == number) {
							la = i;
							lb = j;
							sb.append("L");
						}
					}
				}
			} else if (number == 3 || number == 6 || number == 9) {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 3; j++) {
						if (dial[i][j] == number) {
							ra = i;
							rb = j;
							sb.append("R");
						}
					}
				}
			} else {
				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 3; j++) {
						if (dial[i][j] == number) {
							a = i;
							b = j;
							int BetweenL = Math.abs(a - la) + Math.abs(b - lb);
							int BetweenR = Math.abs(a - ra) + Math.abs(b - rb);
							if (BetweenL < BetweenR) {
								la = i;
								lb = j;
								sb.append("L");
							} else if (BetweenL > BetweenR) {
								ra = i;
								rb = j;
								sb.append("R");
							} else {
								if (hand.equals("right")) {
									ra = i;
									rb = j;
									sb.append("R");
								} else {
									la = i;
									lb = j;
									sb.append("L");
								}
							}
						}
					}
				}
			}
		}

		String answer = sb.toString();
		return answer;
	}

}
