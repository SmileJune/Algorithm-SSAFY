package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_1296_박성현 {
	static int L;
	static int O;
	static int V;
	static int E;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name = sc.nextLine();
		int N = sc.nextInt();
		sc.nextLine();
		int max = 0;
		String teamName = "";
		for (int i = 0; i < N; i++) {
			L = 0;
			O = 0;
			V = 0;
			E = 0;
			String subName = sc.nextLine();
			if (i == 0) 
				teamName = subName;
			addChar(name);
			addChar(subName);
			int prob = ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E)) % 100;
			if (max < prob) {
				max = Math.max(max, prob);
				teamName = subName;
			}
            else if (max == prob) {
                int cnt = 0;
				for (int j = 0; j < Math.min(teamName.length(), subName.length()); j++) {
					if (subName.charAt(j) - 'A' == teamName.charAt(j) - 'A') {
                        cnt++;
						continue;
                    }
					else if (subName.charAt(j) - 'A' < teamName.charAt(j) - 'A') {
						teamName = subName;
						break;
					} 
					else
						break;
				}
                if (cnt == Math.min(teamName.length(), subName.length())) {
                    if (teamName.length() > subName.length())
                        teamName = subName;
                }
                    
			}
		}
		System.out.println(teamName);
	}

	static void addChar(String name) {
		for (int i = 0; i < name.length(); i++) {
			switch (name.charAt(i)) {
			case 'L':
				L++;
				break;
			case 'O':
				O++;
				break;
			case 'V':
				V++;
				break;
			case 'E':
				E++;
				break;
			}
		}
	}
}