package sw.d4;

import java.util.Scanner;
import java.util.Stack;


public class SW_D4_5432_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			Stack<Character> stack = new Stack<>(); // 테스트 케이스 마다 새로운 스택 생성
			
			String bracket = sc.next(); // 괄호를 입력 받아서
			int ans = 0;
			for (int i = 0; i < bracket.length(); i++) { // 그 길이만큼 돌면서 분석을 할 건데
				char c = bracket.charAt(i); // i번째 친구를 c에 담고
				
				if (c == '(') { // 그 아이가 열린 괄호면 스택에 담고 컨티뉴
					stack.push(c);
					continue;
				}
				else {// 닫힌 괄호면
					stack.pop(); // 열린 괄호 하나 빼고 
					
					// 이거 삼항연산자로 해보자
					ans += bracket.charAt(i-1) == '(' ? stack.size() : 1;
//					if (bracket.charAt(i-1) == '(') { // 레이저
//						ans += stack.size(); // 스택에 들어간 막대기 갯수만큼 더해주세요
//					} else { // 쇠막대기
//						ans += 1; // 1 더해주세요
//					}
				}
				// 레이저인지 쇠막대기인지 구분을 할 건데
				// 레이저라면 앞에 애가 (고 => 그러면 스택 사이즈 만큼 더해주고
				// 쇠막대기라면 앞에 애가 )일거야  => 그러면 그냥 1만 더해줘
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
	
}





