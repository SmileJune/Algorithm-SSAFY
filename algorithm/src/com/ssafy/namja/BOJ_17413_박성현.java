package com.ssafy.namja;

import java.util.Scanner;
public class BOJ_17413_박성현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();

		for (int i = 0; i < line.length(); i++) {
			if (i < line.length() && line.charAt(i) == '<') {
				while (line.charAt(i) != '>') {
					System.out.print(line.charAt(i++));
				}
				System.out.print('>');
			} else {
				while (i < line.length() && line.charAt(i) != '<') {
					StringBuffer word = new StringBuffer("");
					while (i < line.length() && (line.charAt(i) != ' ' && line.charAt(i) != '<')) {
						word.append(line.charAt(i++));
					}
					System.out.print(word.reverse());
					if (i < line.length() && line.charAt(i) == ' ') {
						System.out.print(line.charAt(i++));
					}
				}
				i--;
				if (i >= line.length())
					break;
			}
		}
	}
}