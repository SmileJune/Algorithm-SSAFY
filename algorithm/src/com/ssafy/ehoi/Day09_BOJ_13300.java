package com.ssafy.ehoi;

import java.util.Scanner;

public class Day09_BOJ_13300 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 학생수 
		int K = sc.nextInt(); // 방 당 최대 학생수
		
		// 학생 정보 담을 배열 생성
		// 앞이 성별 뒤가 학년이구나
		int[][] arr = new int[2][7]; // 0열은 고려하지 않음
		int count = 0; // 정답 초기화
		
		// 학생 정보도 배열에 다 넣어줌
		for (int i = 0; i < N ; i++) {
			arr[sc.nextInt()][sc.nextInt()]++;
		}
		
		// 배열 순회하면서
		for(int i = 0; i < arr.length; i++) {
			for(int j = 1; j < arr[0].length; j++) {
				// 그 안에 학생이 있고 최대 학생 수의 범위를 넘지 않으면 방 하나 세어주고
				if (arr[i][j] != 0 && arr[i][j] <=K) count++;
				// 최대 한도를 넘으면
				else if (arr[i][j] > K) {
					// 딱 맞아 떨어지면 그 몫 만큼만 방을 더하고
					if (arr[i][j]%K == 0) 
						count += arr[i][j]/K;
					// 나머지가 생기면 +1을 해서 방을 더해준다
					 else 
						 count += arr[i][j]/K + 1;
				}
			}
		}
		
		System.out.println(count);
		
		
		
		sc.close();
	}
}
