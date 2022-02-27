package com.ssafy.hwang;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * [BOJ_3052_나머지]
 * 
 * 입력값을 42로 나눈 나머지 중 서로 다른 나머지들의 갯수를 구하는 문제
 * Set의 특징을 활용하여, 구한 나머지 값을 Set에 넣어주고 size출력
 * input : A ( 10개가 줄바꿈으로 들어옴)
 * output : 서로 다른 A%42 의 갯수
 *
 */
public class Day19_BOJ_3052_나머지 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Set<Integer> set = new HashSet<>();
		for (int tc = 0; tc < 10; tc++) {
			set.add(sc.nextInt()%42);
		}
		System.out.println(set.size());
		sc.close();
	}
}
