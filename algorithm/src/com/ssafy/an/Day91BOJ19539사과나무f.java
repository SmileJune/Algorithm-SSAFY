package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day91BOJ19539사과나무f { // 19539 사과나무, 2번째 조건은 생각해내지 못했습니다.
	static int N, tot;
	static int[] arr, mul;
	static boolean ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		tot = 0;
		arr = new int[N]; // 바라는 높이 배열
		mul = new int[2]; // 횟수 체크 배열
		ans = true;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tot += arr[i] = Integer.parseInt(st.nextToken());
			mul[arr[i] % 2]++;
		} // 1과 2의 물뿌리개 사용 횟수는 같다. 
		  
		if (tot % 3 != 0) // 물뿌리개 동시 사용은 항상 3의 배수
			ans = false;
		else if (tot / 3 < mul[1])  // 이것
			ans = false; 
		System.out.println(ans ? "YES" : "NO");
		br.close();
	}
}
// 1. 항상 3의 배수
// 2. 목표치가 홀수인 나무는 1뿌리개를 무조건 사용해야 하는데,  
// 그 횟수가 2뿌리개와 동일하기 때문에,
// 1뿌리개 횟수는 총합/3 보다 작아야 한다.