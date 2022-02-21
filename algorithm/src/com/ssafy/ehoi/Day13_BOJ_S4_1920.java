package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day13_BOJ_S4_1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 배열 크기 받고
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		// 배열에다가 숫자 넣어서 배열 완성해주고
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 이분 탐색을 할 거면 정렬을 해줘야지
//		for (int i = 0; i < N; i++) {
//			int minIdx = i;
//			for (int j = i+1; j < N; j++) {
//				if(arr[minIdx] > arr[j]) {
//					minIdx = j;
//				}
//			}
//			int tmp = arr[i];
//			arr[i] = arr[minIdx];
//			arr[minIdx] = tmp;
//		}
		Arrays.sort(arr);

		int K = Integer.parseInt(br.readLine());
		// key 갯수 입력받고 => 그거만큼 반복돌면서

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			// key 하나씩 입력 받을 건데
			int key = Integer.parseInt(st.nextToken());

			// 걔가 이제 배열에 있는지 확인을 할 건데
			// 일단 시작과 끝 인덱스를 지정해주고
			int start = 0;
			int end = arr.length - 1;

			// while문에 들어가 조건 st<=end / 이거 지나쳐버리면 key는 여기에 없는거다
			// 들어가서 mid 인덱스 구하고
			// mid랑 키값 비교해서
			// 있으면 1 출력 + break
			// 없으면 다시 찾으러 가게 후처리 해주고
			// while문 나가서 없으면 -1 출력
			boolean flag = false; // 없을 거야!!!
			while (start <= end) {
				int mid = (start + end) / 2;
				if (arr[mid] == key) {
					flag = true;
					System.out.println(1);
					break;
				} 
				if (key > arr[mid]) {
					start = mid + 1;
				} else if (key < arr[mid]) {
					end = mid - 1;
				}

			}
			// st > end 상태 = 찾지 못한 상태
			// flag를 달아주자!
			// 찾지 못한 상태니까 false겠지?
			if (!flag) 
			System.out.println(0); // 지금 이상태로 해놓으면 0을 무조건 출력하잖아... ㅋ
			

		}

	}
}
