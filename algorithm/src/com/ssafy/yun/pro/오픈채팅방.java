package com.ssafy.yun.pro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 오픈채팅방 {

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}

	public static String[] solution(String[] record) {

		HashMap<String, String> map = new HashMap<String, String>();
		ArrayList<String> s = new ArrayList<String>();

		for (String r : record) {
			String[] unit = r.split(" ");

			if (unit.length == 3) {
				map.put(unit[1], unit[2]);
			}

		}

		for (String r : record) {
			String[] unit = r.split(" ");

			if (unit[0].contains("Enter")) {
				s.add(map.get(unit[1]) + "님이 들어왔습니다.");
			} else if (unit[0].contains("Leave")) {
				s.add(map.get(unit[1]) + "님이 나갔습니다.");
			} else {
				continue;
			}

		}

		String[] answer = new String[s.size()];
		for (int i = 0; i < s.size(); i++) {
			answer[i] = s.get(i);
		}

		return answer;
	}
}
