package com.ssafy.yun;

import java.net.*;
import java.io.*;

public class DAEJEON04_TEAM5 {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "DAEJEON04_YUNILJUN";

	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
	// 메서드에서도 편하게 사용할 수 있도록 static으로 선언해서 받아줬다.
	static float[][] balls;
	static float angle;
	static float len;

	// A에서 B를 가리키는 벡터
	public static float[] AtoB(float[] A, float[] B) {
		return new float[] { B[0] - A[0], B[1] - A[1] };
	}

	// 벡터합
	public static float[] sum(float[] A, float[] B) {
		return new float[] { A[0] + B[0], A[1] + B[1] };
	}

	// 내적
	public static float dot(float[] A, float[] B) {
		return A[0] * B[0] + A[1] * B[1];
	}

	// 단위벡터만들기
	public static float[] getUnitVector(float[] A) {
		float length = (float) Math.sqrt(Math.pow(A[0], 2) + Math.pow(A[1], 2));
		return new float[] { A[0] / length, A[1] / length };
	}

	// 반대방향 단위벡터*공의크기
	public static float[] getReversedVector(float[] A) {
		float[] ans = getUnitVector(A);
//		return new float[] { (float) (ans[0] * (-5.73)), (float) (ans[1] * (-5.73)) };
		float weight = (float) -4.7;
		return new float[] { (float) (ans[0] * weight), (float) (ans[1] * weight) };
	}

	// 적절한 홀 찾기
	// 단위벡터 내적값이 가장 높은것이 우리가 쳐야할 홀이다.
	public static float[] getProperHolePosition(int ballNum) {
		int holeIndex = 0;
		float max = -123;
		float[] whiteBall = { balls[0][0], balls[0][1] };
		float[] targetBall = { balls[ballNum][0], balls[ballNum][1] };
		for (int i = 0; i < HOLES.length; i++) {
			float[] hole = { HOLES[i][0], HOLES[i][1] };
			float[] hitVector = getHitVector(whiteBall, targetBall, hole);
			float num = dot(getUnitVector(AtoB(targetBall, hole)), getUnitVector(hitVector));
			if (num > max) {
				max = num;
				holeIndex = i;
			}
		}
		return new float[] { HOLES[holeIndex][0], HOLES[holeIndex][1] };
	}

	// 우리가 쳐야할 공의 번호를 가져와서 다음 단계를 진행한다.
	public static void doNextStep(int ballNum) {
		float[] hole = getProperHolePosition(ballNum);
//		float ballHalf = (float) 0.1;
//		if (hole[0] == 0) {
//			hole[0] += ballHalf;
//		}
//		if (hole[0] == 254) {
//			hole[0] -= ballHalf;
//		}
//		if (hole[1] == 0) {
//			hole[1] += ballHalf;
//		}
//		if (hole[1] == 254) {
//			hole[1] -= ballHalf;
//		}
		float[] whiteBall = { balls[0][0], balls[0][1] };
		float[] targetBall = { balls[ballNum][0], balls[ballNum][1] };

		float[] hit = getHitVector(whiteBall, targetBall, hole);
		len = (float) Math.sqrt(Math.pow(hit[0], 2) + Math.pow(hit[1], 2));
		angle = (float) Math.atan2(hit[1], hit[0]);
		angle = (float) (90 - Math.toDegrees(angle));
	}

	// 공이 나아가야할 방향과 길이 만큼의 벡터를 구한다.
	public static float[] getHitVector(float[] whiteBall, float[] targetBall, float[] hole) {
		float[] whiteToTarget = AtoB(whiteBall, targetBall);
		float[] targetToHole = AtoB(targetBall, hole);
		float[] reversedVector = getReversedVector(targetToHole);
		float[] hit = sum(whiteToTarget, reversedVector);
		return hit;
	}

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int) balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				angle = 0.0f;
				float power = 0.0f;

				// - order: 1인 경우 선공, 2인 경우 후공을 의미

				// 1 3 5 또는 2 4 5 순으로 확인.

				// 내가 첫번째일때는 고정으로 위나 아래부터 판단 1 3 먼저 치기

				for (int i = 1; i <= 3; i++) {
					int index = 2 * i - 1 + (order - 1);
					if (i == 3) {
						index = 5;
					}

					// 해당하는 숫자가 둘다 양수면 다음 단계진입. 돌고 for문 나가기.
					if (balls[index][0] >= 0 && balls[index][1] >= 0) {
						doNextStep(index);
						break;
					}

				}
				power = 53;

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
