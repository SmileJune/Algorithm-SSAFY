package com.ssafy.yun.pro;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
	public static void main(String[] args) {
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };
		System.out.println(solution(participant, completion));
	}

	static public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> participantMap = new HashMap<>();

		setParticipantMap(participant, participantMap);
		setZeroValueToCompletion(completion, participantMap);

		for (Map.Entry<String, Integer> element : participantMap.entrySet()) {
			if (element.getValue() == 1) {
				return element.getKey();
			}
		}

		return null;
	}

	static private void setZeroValueToCompletion(String[] completion, HashMap<String, Integer> map) {
		for (int i = 0; i < completion.length; i++) {
			int valueMinusOne = map.get(completion[i]) - 1;
			map.put(completion[i], valueMinusOne);
		}
	}

	static private void setParticipantMap(String[] participant, HashMap<String, Integer> map) {
		for (int i = 0; i < participant.length; i++) {
			if (map.containsKey(participant[i])) {
				int valuePlusOne = map.get(participant[i]) + 1;
				map.put(participant[i], valuePlusOne);
				continue;
			}
			map.put(participant[i], 1);
		}
	}
}
