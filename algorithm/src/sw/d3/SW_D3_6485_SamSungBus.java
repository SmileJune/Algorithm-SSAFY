package sw.d3;

import java.util.Scanner;

public class SW_D3_6485_SamSungBus {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 문제 해석이 너무 어렵고요?
		// 일단 테스트 케이스 받고
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int[] bus = new int[5001]; // 버스 정류장 배열 5001개를 생성합니다

			int N = sc.nextInt();// N개의 노선을 입력받고

			for (int i = 0; i < N; i++) { // N만큼 반복 돌면서
				int from = sc.nextInt();
				int to = sc.nextInt(); // from노선과 to노선을 입력받습니다.

				for (int j = from; j <= to; j++) {
					bus[j]++; // 그리고 그 번호에 해당하는 곳에 정류장 배열을 더해줍니다
				}

			}

			int P = sc.nextInt(); // 다 하고 나면 P를 입력받고
			
			System.out.printf("#%d ", tc);
			for(int i = 0; i < P; i++) {
				System.out.print(bus[sc.nextInt()]+" ");
			} 
			
			
			
//			StringBuilder sb = new StringBuilder();
//			sb.append("#").append(tc).append(" ");
//			for (int i = 0; i < P; i++) {
//				int p = sc.nextInt();
//				sb.append(bus[p]).append(" ");
//			}
//			System.out.println(sb);
			
		}

		
		// 1부터 P까지의 정류장 배열의 값을 출력하면 된다.

		sc.close();
	}
}
