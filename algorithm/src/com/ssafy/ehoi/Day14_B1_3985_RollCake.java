package com.ssafy.ehoi;

import java.util.Scanner;

public class Day14_B1_3985_RollCake {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 롤케이크 길이 입력 받기
		int L = sc.nextInt();
		// 배열 길이 +1 로 생성하기
		int[] cake = new int[L+1];
		// 손님 수 입력받기
		int N = sc.nextInt();
		// 손님이 원하는 조각의 길이를 저장할 배열 만들기
		int[][] want = new int[N+1][2];
		
		// 손님 수 만큼 반복돌면서 배열에 입력하기
		for (int i = 1; i <=N ; i++) {
			want[i][0] = sc.nextInt(); // p부터
			want[i][1] = sc.nextInt(); // k까지
		}
		
		// 가장 많은 조각을 신청한 고객
		// p-k 가 가장 큰 고객을 찾자!
		int maxIdx = N; // 마지막 고객으로 초기화
		int max = 0; // 가장 많은 조각
		for (int i = N; i>=1; i--) { // max가 동일하다면 번호가 작은 사람이 갱신되어야 하니까 뒷번호부터 비교
			int myWant = want[i][1] - want[i][0]; // 내 조각 수
			if (myWant >= max) { // 동일한 거 까지 생각해야 하네
				max = myWant; // 얘를 갱신해놔야 다음 애랑 비교가 가능
				maxIdx = i; // max 신청한 고객도 갱신
			}
		}
		System.out.println(maxIdx);
		
		// 가장 많은 조각을 받은 고객을 찾아야 하는데
		// 그러려면 그전에 각 고객이 케이크를 어디부터 어디까지 신청했는지를 케이크 배열에 기록해야해
		for (int i = 1; i <= N; i++) { // i : 손님
			int from = want[i][0]; // i번째 고객이 원하는 시작부터
			int to = want[i][1]; // 끝의 케이크 조각
			
			for (int j = from; j <= to; j++) { // 원하는 구간까지 표시를 할건데
				if (cake[j] == 0) { // 원하는 사람이 없었어야 
					cake[j] = i; // 손님 번호를 적는다
				}
			}
		}
		// 그리고 각 고객이 받을 수 있는 케이크 수를 카운팅 배열에다가 세고
		// 카운팅 배열의 크기 : 손님 수 +1
		int[] howMany = new int[N+1];
		for (int i = 1; i < cake.length; i++) {
			howMany[cake[i]]++;
		}
		// 어느 고객이 케이크 수가 가장 큰지 찾아야해 
		int realMax = 0; // 이거는 케이크 최대로 많이 받는 조각 수가
		int realMaxIdx = 0 ; // 많이 받는 손님 번호 
		for (int i = 1; i <= N ; i++) {// 손님 1번부터 N번까지 
			if (howMany[i] > realMax) {
				realMax = howMany[i];
				realMaxIdx = i;
			}
		}
		System.out.println(realMaxIdx);
		sc.close();
	}
}
