package sw.d2;

import java.util.Scanner;

public class SW_D2_1940_RCcar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 갯수 받기
		
		for (int tc = 1; tc <= T; tc ++) { // 테케만큼 반복하기
			int N = sc.nextInt(); // 커맨드 갯수 받기
			
			int speed = 0; // 처음 속도 0 초기화
			int ans = 0; // 최종 거리 0 초기화
			for (int i = 0; i < N; i++) { // 커맨드 만큼 반복
				int command = sc.nextInt(); // 명령 받기
				
				switch(command) {
				case 0: // 현재 속도 유지일때
					// 스피드에 변화 없고
					ans += speed; // 현재 속도 그대로 거리에 더해주면 됨
					break;
				case 1: // 가속임
					int excel = sc.nextInt(); // 얼마나 가속할지 입력 받고
					speed += excel; // 속도 올려주고
					ans += speed; // 어차피 1초 단위로 명령 새로 받아서 시간 곱해줄 필요 없음
					break;
				case 2: // 감속임
					excel = sc.nextInt();
					speed = speed - excel < 0 ? 0 : speed - excel;
					ans += speed; // 어차피 1초 단위로 명령 새로 받아서 시간 곱해줄 필요 없음
					break;
				}
				
			}
			System.out.printf("#%d %d\n", tc, ans);
		}
		sc.close();
	}
}
