package com.ssafy.namja;

import java.util.Scanner;
/*K : 한 방에 배정가능한 최대 인원 수
같은 성별끼리 한 방, 같은 학년끼리 한 방*/

/*입력
N (: 수학여행에 참가하는 학생 수), K (: 한 방에 배정가능한 최대 인원 수)
Si (: i번째 학생의 성별 / 0 : 여학생 1 : 남학생) Yi (:i번째 학생의 학년)*/

/*출력
필요한 최소한의 방 갯수*/

public class BOJ_13300_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();	// 학생 수
		int K = sc.nextInt();	// 방당 최대 인원 수
		
		int[][] grades = new int[2][6];	// 학년, 성별 당 인원 수
		
		for (int i = 0; i < N; i++) {
			int s = sc.nextInt();	// 성별
			int y = sc.nextInt();	// 학년
			grades[s][y-1]++;	// 해당하는 배열의 값에 ++로 인원 파악
		}
		
		int rooms = 0;	// 방 갯수
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				rooms += grades[i][j] / K;	// K로 나눈 몫을 방 갯수에 더하기
				if (grades[i][j] % K != 0)	// 나머지가 0이 아니라면 방 하나 추가
					rooms += 1;
			}
		}
		System.out.println(rooms);
	}
}