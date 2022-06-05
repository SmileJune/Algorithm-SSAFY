package com.ssafy.an.day149;

import java.util.Scanner;

public class Day119BOJ17478재귀출력기초 { // 17478 재귀함수가 뭔가요?
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		sb.append(O);
		recur(N = sc.nextInt());
		System.out.println(sb);
		sc.close();
	}

	// 쉬운 문제지만 중복라인 줄여보니 뿌듯하네요.
	private static void recur(int n) {
		chat(n, A);
		if (n != 0) {
			chat(n, B, C, D);
			recur(n - 1);
		} else
			chat(n, E);
		chat(n, F);
	}

	private static void chat(int n, String... str) {
		for (int s = 0; s < str.length; s++) {
			for (int i = n; i < N; i++) {
				sb.append("____");
			}
			sb.append(str[s]);
		}
	}

	static String O = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
	static String A = "\"재귀함수가 뭔가요?\"\n";
	static String B = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어. \n";
	static String C = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	static String D = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	static String E = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	static String F = "라고 답변하였지.\n";
}
