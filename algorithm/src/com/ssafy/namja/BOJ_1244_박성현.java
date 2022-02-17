package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1244_박성현 {
	static int[] switArr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int swit_num = sc.nextInt(); // 스위치 갯수
		switArr = new int[swit_num]; // 스위치 상태 모음
		for (int i = 0; i < swit_num; i++) // 스위치 상태 배치
			switArr[i] = sc.nextInt();

		int stu_num = sc.nextInt(); // 학생 수
		int[][] stuArr = new int[stu_num][2]; // 학생 성별과 받은 번호
		for (int i = 0; i < stu_num; i++) {
			stuArr[i][0] = sc.nextInt(); // 성별
			stuArr[i][1] = sc.nextInt(); // 번호
		}

		for (int i = 0; i < stu_num; i++) {
			if (stuArr[i][0] == 1) {
				maleSwitch(stuArr[i][1]);
			} else {
				femaleSwitch(stuArr[i][1]);
			}
		}

		for (int i = 0; i < switArr.length; i++) {
			System.out.printf("%d ", switArr[i]);
			if ((i+1) % 20 == 0)
				System.out.println();
		}
		sc.close();
	}

	static void maleSwitch(int num) {
		for (int i = 1; i <= switArr.length; i++) {
			if (i % num == 0) {
				switArr[i - 1] = (switArr[i - 1] + 1) % 2;
			}
		}
	}
	
	static void femaleSwitch(int num) {
		int idx = num-1;
		int idx_max = 0; // 배열 범위 초과 체크용
		int cnt = 0;
		for (int i = 1; i <= switArr.length; i++) {
			if (num == switArr.length || num == 1) {
				idx = num - 1;
				break;
			}
			if (idx == 0 || idx_max == switArr.length - 1)
				break;
			if (switArr[num-1-i] == switArr[num-1+i]) {
				cnt++;
				idx = num-1-i;
				idx_max = num-1+i;
			}
			else break;
		}
		for (int i = idx; i <= idx+cnt*2; i++) {
			switArr[i] = (switArr[i] + 1) % 2;
		}
	}
}