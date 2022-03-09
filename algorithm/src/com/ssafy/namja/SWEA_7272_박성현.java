package com.ssafy.namja;

import java.util.Scanner;

public class SWEA_7272_박성현 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			String hole0 = "CEFGHIJKLMNSTUVWXYZ";
			String hole1 = "ADOPQR";
			for (int t = 1; t <= T; t++) {
				String line1 = sc.next();
				String line2 = sc.next();
				for (int i = 0; i < line1.length(); i++) {
					if (hole0.contains(line1.charAt(i) + ""))
						line1 = line1.replace(line1.charAt(i), 'C');
					else if (hole1.contains(line1.charAt(i) + ""))
						line1 = line1.replace(line1.charAt(i), 'A');
				}
				for (int i = 0; i < line2.length(); i++) {
					if (hole0.contains(line2.charAt(i) + ""))
						line2 = line2.replace(line2.charAt(i), 'C');
					else if (hole1.contains(line2.charAt(i) + ""))
						line2 = line2.replace(line2.charAt(i), 'A');
				}
				System.out.printf("#%d %s\n",t, line1.equals(line2) ? "SAME" : "DIFF");
			}
		}
	}
