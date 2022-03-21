package com.ssafy.hwang;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Day42_BOJ_오늘날짜 {
	public static void main(String[] args) {
		Date now = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String nowTime1 = sdf1.format(now);

		System.out.println(nowTime1);

	}
}
