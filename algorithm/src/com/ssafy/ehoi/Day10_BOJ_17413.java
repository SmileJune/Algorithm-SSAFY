package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 태그라면
// 1. 공백이 있어도 구분하지 않고
// 2. 뒤집지도 않는다
// 단어라면
// 1. 공백을 기준으로 구분하여 뒤집는다
public class Day10_BOJ_17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean tag = false; // 태그가 열리지 않은 상태
		String txt = br.readLine();
		
		String word = ""; // 빈 문자열
		for (int i = 0; i < txt.length(); i++) { // 이제 문자 읽을건데
			if (txt.charAt(i) == '<') { //태그 시작을 알린다!!!
				tag = true;
				reversePrint(word); // 내 앞까지 쌓인 단어 다 뒤집어 출력해
				word = ""; // word 다시 초기화
			}
			if(tag) { // 태그 안
				// 태그 안에서는 그대로 하나씩 다 출력
				// 공백이고 뭐고 신경 안씀
				System.out.print(txt.charAt(i)); 
				if (txt.charAt(i) =='>') tag = false;
			}
			else { // 태그 밖 = 단어 => 공백 기준으로 뒤집기
				if (txt.charAt(i)==' ') {
					reversePrint(word);
					word = "";
					System.out.print(" ");
				} else { // 단어라면 차곡차곡 word에 추가하세용
					word += txt.charAt(i); // 이거 char인데 어케 string에 들어가지
				}
			}
			
		}
		reversePrint(word);
	}
	
	private static void reversePrint(String word) {
		for (int i = word.length()-1; i >= 0; i--) {
			System.out.print(word.charAt(i));
		}
	}
	
}
