package sw.d3;

import java.util.Arrays;
import java.util.Scanner;

public class SW_D3_4789 {
	// 기립박수 받고 싶어서 별 짓을 다하네?
	// 공연이 끝나고 난뒤~ 바로 기립박수를 할 인원을 '최소로' 고용하려고 한다!
	// 손님은 최대 1001명
	// '0'은 아무도 없어도 바로 기립하는 사람의
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String str = sc.next(); // 손님정보가 문자열로 들어와
			int N = str.length();
			int[] num = new int[N]; // 손님수만큼 배열 생성하고
			for (int i = 0; i < N; i++) {
				num[i] = str.charAt(i) - '0'; // 숫자로 만들어서 넣기
			}

//			System.out.println(Arrays.toString(num));
			int ans = 0;
			// 생각해보니까 배열전체에서 0을 가진 애 숫자만 세면 된다
			// 아님 합을 무조건 세어봐야함!!!!

			for (int i = 1; i < num.length; i++) { // i => 나에게 필요한 사람 수
				int sum = 0;
				for (int j = 0; j < i; j++) {
					sum += num[j]; // 내 앞에서 박수친 사람 수
				}
				if (sum < i) { // 박수친 사람이 모자라면
					int needed = i - sum; // 이만큼 고용을 해야하고
					num[i-1] += needed; // 그 사람을 내 직전 자리에 넣어두고
					ans += needed; // 총 고용할 사람 수에 추가
				}
			}
			
//			System.out.println(Arrays.toString(num));
			System.out.printf("#%d %d\n", tc, ans);
		} // 테케 끝

		sc.close();
	}
}
