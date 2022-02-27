package sw.d3;

import java.util.Arrays;
import java.util.Scanner;

// 20분 소요
public class SW_D3_5356 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {
			char[][] ch = new char[5][];
			for (int i = 0; i < ch.length; i++) {
				ch[i] = sc.next().toCharArray();
			}
//			System.out.println(Arrays.deepToString(ch));
			
			// 제일 긴 열의 길이를 알아보자
			int max = 0;
			for (int i = 0; i < ch.length; i++) {
				if(ch[i].length > max) max = ch[i].length;
			}
			System.out.printf("#%d ", tc);
			for (int j = 0; j < max; j++) {
				for (int i = 0; i < ch.length; i++) {
					if (j < ch[i].length) {
						if(ch[i][j] == ' ') continue;
						System.out.print(ch[i][j]);
					}
				}
			}
			System.out.println();
		}
		
		
		
		sc.close();
	}
}
