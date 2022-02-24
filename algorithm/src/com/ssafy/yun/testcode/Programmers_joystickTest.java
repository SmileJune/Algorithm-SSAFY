package com.ssafy.yun.testcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ssafy.yun.Programmers_joystick;

class Programmers_joystickTest {

	Programmers_joystick q;

	@BeforeEach
	void setup() {
		q = new Programmers_joystick();
	}

	@SWEA_7272
	void test1() {
		assertEquals(23, q.solution("JAN"));
	}
	@SWEA_7272
	void test2() {
		assertEquals(56, q.solution("JEROEN"));
	}
	
	@SWEA_7272
	void test3() {
		assertEquals(0, q.solution("A"));
	}
	@SWEA_7272
	void test4() {
		assertEquals(1, q.solution("AB"));
	}
	

}
