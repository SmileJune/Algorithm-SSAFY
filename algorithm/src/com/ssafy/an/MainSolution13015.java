
package com.ssafy.an;

import java.util.Scanner;

public class MainSolution13015 { // 13015 별찍기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num * 2 - 1; i++) {
			if (i == 0 || i == num * 2 - 2) {
				// case1 : 맨위, 맨아래 - 별갯수 만큼 출력과 사이 공백 계산해서 넣기
				for (int j = 0; j < num; j++) {
					System.out.print("*");
				}
				for (int j = 0; j < num * 2 - 3; j++) {
					System.out.print(" ");
				}
				for (int j = 0; j < num; j++) {
					System.out.print("*");
				}
				System.out.print("\n");
			} else if (i == num - 1) {
				// case2 : num - 1, 즉 0을 기준으로 엑스에 가운데 별 3개 값
				for (int j = 0; j < num - 1; j++) {
					System.out.print(" ");
				}
				System.out.print("*"); // 첫번째 별은 1번 열의 num번째 랑 같은 위치
				for (int j = 0; j < num - 2; j++) {
					System.out.print(" ");
				}
				System.out.print("*"); // 공백은 num-2씩 유지됨.
				for (int j = 0; j < num - 2; j++) {
					System.out.print(" ");
				}
				System.out.print("*\n");
			} else {
				// case3 : 별을 4개씩찍는데, 홀수 별과 짝수별의 차이는 num-2만큼 씩
				for (int j = 0; j < (num - 1) - Math.abs(num - 1 - i); j++) {
					System.out.print(" ");
				} // 1/4부분 먼저 그려보고, 절대값으로 반대쪽 그리기
				System.out.print("*");
				for (int j = 0; j < num - 2; j++) {
					System.out.print(" ");
				}
				System.out.print("*");
				for (int j = 0; j < 2 * Math.abs((num - 1) - i) - 1; j++) {
					System.out.print(" ");
				}
				System.out.print("*");
				for (int j = 0; j < num - 2; j++) {
					System.out.print(" ");
				}
				System.out.print("*\n");
			}
		}
		sc.close();
	}
}
//***   ***
// * * * *
//  * * *
// * * * *
//***   ***  
//
//*****       *****
// *   *     *   *
//  *   *   *   *
//   *   * *   *
//    *   *   *
//   *   * *   *
//  *   *   *   *
// *   *     *   *
//*****       *****