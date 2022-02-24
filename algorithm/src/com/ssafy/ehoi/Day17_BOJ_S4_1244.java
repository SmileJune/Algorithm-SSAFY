package com.ssafy.ehoi;

import java.util.Scanner;

public class Day17_BOJ_S4_1244 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 스위치 개수
		int[] swich = new int[N + 1]; // 인덱스를 스위치 번호로 활용하려고 하나 크게 생성
		for (int i = 1; i <= N; i++) {
			swich[i] = sc.nextInt();
		} // 스위치 배열에 정보 입력 끝

//		System.out.println(Arrays.toString(swich));

		int S = sc.nextInt(); // 학생 수
		int[][] student = new int[S][2]; // 학생수 * (성별과 받은 수)
		for (int i = 0; i < S; i++) { 
			for (int j = 0; j < student[i].length; j++) {
				student[i][j] = sc.nextInt();
			}
		} // 학생 정보도 입력 끝

//		System.out.println(Arrays.deepToString(student));

		for (int i = 0; i < student.length; i++) {// 학생수만큼 돌면서
			if (student[i][0] == 1) { // 성별 검사 : 남자이면
				int num = student[i][1]; // 너가 받은 수를 담아놓고
				for (int k = 1; k <= N; k++) { // 스위치 번호만큼
					if (k % num == 0) { // 스위치가 내가 받은 수의 배수이면
						swich[k] = swich[k] == 0 ? 1 : 0;
					}
				}
			} else { // 여자이면
				int num = student[i][1]; // 역시 너도 받은 수 담고
				swich[num] = swich[num] == 0 ? 1 : 0; // 그 해당 스위치 눌러줘

				int q = 1;
				// 범위체크 해야해! 인덱스가 이 범위 안에 없으면 안돼!
//				while (true) { // 내가 여기 조건문 잘못 줘서 틀렸어!!!! 
//					if (num - q < 1 || num + q > N) // 범위 체크
//						break;
//					if (swich[num - q] == swich[num + q]) { // 그리고 양 옆에 있는 애들이 같다면
//						swich[num - q] = swich[num - q] == 0 ? 1 : 0;
//						swich[num + q] = swich[num + q] == 0 ? 1 : 0;
//					} else break;
//					q++;
//				}
				
				while(1 <= num - q && num + q <= N) {
					if (swich[num - q] == swich[num + q]) { // 그리고 양 옆에 있는 애들이 같다면
						swich[num - q] = swich[num - q] == 0 ? 1 : 0;
						swich[num + q] = swich[num + q] == 0 ? 1 : 0;
						q++;
					} 
					else { 
						break;
					}
				}
			}

		}
//		System.out.println(Arrays.toString(swich));
		// 출력 한 줄에 20개!
		// 스위치 갯수가(배열로 따진다면 21개) 20개를 넘는다면 20개씩 출력한다!
		
		for(int i = 1; i < swich.length; i++) {
			System.out.print(swich[i] + " ");
			if (i % 20 == 0) { // 20번째마다 줄바꿈
				System.out.println();
			}
		}
		
		
		sc.close();
	}
}
