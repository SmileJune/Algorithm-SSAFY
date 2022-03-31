package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 깊이가 K -> 2^K -1 개의 노드
// 완전 이진 트리
// 중위 순회 방식으로 빌딩에 들어감
public class Day51_BOJ_S1_9934 {
	static int K;
	static int[] arr;
	static StringBuffer[] ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 깊이 입력
		K = Integer.parseInt(br.readLine());
		
		// 노드 개수 계산 해서 배열 생성하고 입력받기
		arr = new int[(int)Math.pow(2, K)-1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		System.out.println(Arrays.toString(arr));
		// 정답 배열만들기
		// 이 때 K줄에 걸쳐 출력하라고 했으니
		// 배열 크기를 K크기만큼 만들고
		// 각 배열에 스트링버퍼를 단다.
		ans = new StringBuffer[K];
		for(int i = 0; i < ans.length; i++) {
			ans[i] = new StringBuffer();
		}
		
		// 가운데 애가 출력이 되어야 하는 메서드를 던진다.
		// (배열의 시작, 배열의 끝 + 1, 그리고 내가 출력되어야 하는 정답 배열의 인덱스)
		solution(0, arr.length, 0);
		
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		
	}
	
	public static void solution(int s, int e, int depth) {
		// 재귀파트 : depth 가 K가 되었다면 리턴
		if(depth == K) return;
		
		int m = (s + e) / 2;
		ans[depth].append(arr[m]).append(" ");
		solution(s, m, depth+1);
		solution(m, e, depth+1);
		
	}
}
