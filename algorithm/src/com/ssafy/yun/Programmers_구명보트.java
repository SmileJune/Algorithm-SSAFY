package com.ssafy.yun;

import java.util.Arrays;

public class Programmers_구명보트 {

	public int solution(int[] people, int limit) {
		boolean[] visited = new boolean[people.length];
		Arrays.sort(people);

		int cnt = 0;
		int numberOfBoat = 0;
		while (cnt < people.length) {
			int lim = limit;
			numberOfBoat++;
			int peopleNum = 0;
			for (int i = people.length - 1; i >= 0; i--) {
				if (people[i] <= lim && visited[i] == false) {
					lim -= people[i];
					visited[i] = true;
					cnt++;
					peopleNum++;
				}
				if (peopleNum == 2) {
					break;
				}
			}
		}
		return numberOfBoat;
	}
}
