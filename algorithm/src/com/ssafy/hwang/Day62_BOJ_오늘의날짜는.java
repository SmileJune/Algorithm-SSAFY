package com.ssafy.hwang;

import java.time.LocalDate;

public class Day62_BOJ_오늘의날짜는 {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		
		System.out.println(now.getYear());
		System.out.println(now.getMonthValue());
		System.out.println(now.getDayOfMonth());
	}
}
