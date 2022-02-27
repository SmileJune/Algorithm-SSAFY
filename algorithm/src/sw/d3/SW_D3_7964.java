package sw.d3;

import java.util.Arrays;
import java.util.Scanner;

//16시 50분 - 17시 44분 : 55분 소요 
public class SW_D3_7964 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 제목 수
			
			boolean[] hasTitle = new boolean['Z'-'A'+1]; // 에이부터 제트까지 타이틀 있는지 없는지 확인하는 배열
			
			for(int i = 0 ; i < N; i++) {
				hasTitle[sc.next().charAt(0) - 'A'] = true;
			} // 해당 대문자 갖고 있는 배열에만 true 값
			
			int cnt = 0;
			for (int i = 0; i < hasTitle.length; i++) {
				if (hasTitle[i]) {
					cnt++;
				} else break;
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
		}
		
		
		
		sc.close();
	}
}
