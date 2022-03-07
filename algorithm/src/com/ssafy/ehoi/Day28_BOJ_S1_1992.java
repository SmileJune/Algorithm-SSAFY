package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
 * N은 언제나 2의 제곱수
 * 1, 2, 4, 8, 16, 32, 64
 * 문자열로 들어오니까 charAt 써야겠군! 
 */
public class Day28_BOJ_S1_1992 {
	static int[][] video;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				video[i][j] = (tmp.charAt(j) - '0');
			}
		} // 영상 정보 입력 완료
		
//		System.out.println(Arrays.deepToString(video));
		
		// 압축 결과 체크 메서드를 던진다! 
		check(0, 0, N);
		
		bw.append(sb);
		bw.flush();
		bw.close();
	}
	
	// 메서드로 구현할 것
	// 1번
	// 다 같은 숫자로 이루어져 있는지 체크할 boolean 메서드
	// 2번
	// true라면 1) 0이라면 0을 리턴, 2) 1이라면 1을 리턴 (정복)
	// false라면 size을 1/2으로 나눠서 다시 던지는 메서드 (분할)
	// 괄호를 씌워진채로 리턴되어야해 
	static int[] dr = {0, 0, 1, 1};
	static int[] dc = {0, 1, 0, 1};
	
	static StringBuilder sb = new StringBuilder();
	
	public static void check(int r, int c, int size) {
		
		if (isSame(r, c, size)) { // true면
			sb.append(video[r][c]); // 그냥 시작인덱스 붙여라!
			return;
		}
		// 그게 아니라면 
		size /= 2;
		sb.append('(');
		for (int d = 0; d < 4; d++) {
			check(r + size*dr[d], c + size*dc[d], size);
		}
		sb.append(')');
		
	}
	
	// 다 같은 숫자로 == 즉 압축할 수 있는지 
	public static boolean isSame(int r, int c, int size) {	
		if (size == 1) return true;
		
		int pivot = video[r][c]; // 기준이 될 시작 인덱스
		
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (video[i][j] != pivot) {
					return false; // 다르다면 거짓이네! 리턴
				}
			}
		}
		
		return true; // 너네 같군! 리턴
	}
}
