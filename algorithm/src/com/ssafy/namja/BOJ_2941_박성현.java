package com.ssafy.namja;

import java.util.Scanner;

public class BOJ_2941_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.nextLine();
		
		int cnt = 0;
		for (int i = 0; i < word.length(); i++) {
			switch(word.charAt(i)) {
			case 'c':
				if (i < word.length() - 1 && (word.charAt(i+1) == '=' || word.charAt(i+1) == '-'))
					i++;
				cnt++;
				break;
			case 'd':
				if (i < word.length() - 1 && word.charAt(i+1) == '-')
					i++;
				else if (i < word.length() - 1 && word.charAt(i+1) == 'z')
					if (i < word.length() - 2 && word.charAt(i+2) == '=')
						i += 2;
				cnt++;
				break;
			case 'l':
				if (i < word.length() - 1 && word.charAt(i+1) == 'j')
					i++;
				cnt++;
				break;
			case 'n':
				if (i < word.length() - 1 && word.charAt(i+1) == 'j')
					i++;
				cnt++;
				break;
			case 's':
				if (i < word.length() - 1 && word.charAt(i+1) == '=')
					i++;
				cnt++;
				break;
			case 'z':
				if (i < word.length() - 1 && word.charAt(i+1) == '=')
					i++;
				cnt++;
				break;
			default:
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}