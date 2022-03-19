package sw.d3;

import java.util.ArrayList;
import java.util.Scanner;

// 14시 25분 - 15시 40분 : 75분 소요
public class SW_D3_4698 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 소수가 아닌 배열을 먼저 만들어보자
		// false가 소수고
		// true가 소수가 아니다
		// 소수가 아닌 애들을 true로 바꿔주는 게 쉽기 때문에
		boolean[] isNotPrime = new boolean[1000001];
		isNotPrime[0] = isNotPrime[1] = true; // 0과 1은 소수가 아니므로
		// 이제부터 소수 아닌 다른 친구들 찾으러 간다!
		for (int i = 2; i*i <= 1000001; i++) { // 이 범위는 이미 이해하고 있고
			// false인 애들중에서
			if (!isNotPrime[i]) {
				for(int j = i*i; j < 1000001; j += i) {
					isNotPrime[j] = true; // 소수가 아니라고 바꿔준다
				}
			}
		}
		
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String D = sc.next();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			// 소수를 문자열로 담을 배열 만들어야지
			ArrayList<String> prime = new ArrayList<>();
			
			// 소수배열에 담아야지
			for (int i = A; i <= B ; i++) {
				if(!isNotPrime[i]) { // 소수이면
					prime.add(""+i); // 문자열로 바꿔서 넣어야지
				}
			}
			
			// 이제 D를 포함하는지 찾아야해
			int cnt = 0 ;
			for (int i = 0; i < prime.size(); i++) {
				if (prime.get(i).contains(D)) { // i번째 소수가 D를 가지고 있다면
					cnt++;
				}
			}

			System.out.printf("#%d %d\n", tc, cnt);
		}// 테케 끝

		sc.close();
	}


}
