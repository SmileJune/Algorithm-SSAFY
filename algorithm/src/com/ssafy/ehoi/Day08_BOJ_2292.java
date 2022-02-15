package com.ssafy.ehoi;

import java.util.Scanner;

public class Day08_BOJ_2292 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int floor = 1;
		int range_start = 2; // 2층의 시작이 2임
		
		//N이 1인 경우와
		if (N==1) {
			System.out.println(1);
		} 
		// 그 외의 경우
		else {
			// 범위의 시작이 N보다 크다면 그 직전의 floor가 답이 될 것이므로 
			// 이런식으로 조건을 지정
			while (range_start <= N) {
				// 그리고 조건을 바꿔줘야 하니까 이렇게 하면 3층의 시작의 수로 변경됨
				range_start += 6*floor;
				floor++;
			}
			
		}
		// 와 너무 어려운데? 
		
		System.out.println(floor);
		sc.close();
	}
}

//		while(true) {
//			if (1+6*(i-1)*(i)/2 < N && N <= 1+6*(i-1)*i/2) { //왜 나를 쓰루하는가!!!!
//				break;
//			}		
//			i++;
//		}