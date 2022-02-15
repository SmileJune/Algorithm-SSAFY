package com.ssafy.ehoi;

import java.util.Scanner;

// N보다 하나 큰 배열을 생성하고
// 배열의 어느 하나의 값이 M이 되는 순간 끝이니까 M만큼만 반복을 돌면 되겠다
// 

public class Day08_BOJ_1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		sc.close();
		if(M==1) {
			System.out.println(0);
			return;
		}
		
		int[] arr = new int[N + 1];

		int temp = 1; // 공을 받은 사람
		arr[temp] = 1; // 이미 받았으니 횟수를 1로 초기화

		int sum = 0;
		
		// 이 반복문의 의미가 정확한지 모르겠음
		// 얼마나 반복을 해야 하지?
//		while문을 써야할 거 같은데 
		while (true) {
			// 현재 공을 받은 사람이 홀수 번 받았다면 temp+L
			// 현재 공을 받은 사람이 짝수번 받았다면 temp-L
			temp = arr[temp]%2!=0 ? temp+L : temp-L;
			
			// 다음 받을 사람이 N보다 커져버리면
			if(temp > N) {
				// 나머지를 통해서 7%5=2가 받고
				temp = temp%N;
				// 0 이하가 나오면 N만큼 더해서 -1이 나오면 +5 해서 4가 받아요
			} else if (temp < 1) {
				temp += N;
			}
			
			// 그래서 공을 받은 사람의 값을 다시 증가시켜요
			arr[temp]++;
			
			// 현재 공을 받은 사람의 값이 M과 같다면
			if (arr[temp] == M) {
				// 배열의 모든 값을 다 더한 후에
				for (int j = 1; j <= N; j++) {
					sum += arr[j];
				}
				// 나가
				break;
			}

		}


		System.out.println(sum-1);

	}
}
