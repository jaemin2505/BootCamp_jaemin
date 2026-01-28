package javaFund;

import java.util.Scanner;

public class Score2 {
	/*
	 * 학생의 성적을 국, 영, 수로 입력받아서 총점, 평균, 학점(A, B, C, F) 를 출력하도록 하는 프로그램 프로그램이 시작되면 각
	 * 과목을 입력받도록 하는데, 입력된 점수는 반드시 0~100점 사이여야 함 만약 이 범위를 벗어나면 해당 과목을 다시 입력받로고 함. 다른
	 * 과목의 입력으로 넘어가면 안됨
	 * 
	 * 만약 올바른값이 모두 입력되면, 위 결과를 출력
	 * 
	 * 모든 점수는 배열로 관리되어야 함 학점은 90점 이상 A, 80 이상 B, 나머진 F처리하는데, switch case 사용
	 * 
	 * 
	 * 3명의 성적을 입력받아야 함
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] score[] = new int[3][4];
		String subject[] = { "국어", "영어", "수학" };
		String grade = "";

		for (int cnt = 0; cnt < score.length; cnt++) {
			for (int i = 0; i < score.length; i++) {
				System.out.printf("%d번째 학생의 %s 점수를 입력하세요\n", cnt + 1, subject[i]);
				score[cnt][i] = sc.nextInt();
				while (score[cnt][i] < 0 || score[cnt][i] > 100) {
					System.out.println("올바른 점수를 입력하세요");
					score[cnt][i] = sc.nextInt();
				}
				score[cnt][3] += score[cnt][i];
			}

			for (int i = 0; i < score.length; i++) {
				switch (score[cnt][i] / 10) {
				case 10:
				case 9:
					System.out.printf("%s : A학점\n", subject[i]);
					break;
				case 8:
					System.out.printf("%s : B학점\n", subject[i]);
					break;
				case 7:
					System.out.printf("%s : C학점\n", subject[i]);
					break;
				default:
					System.out.printf("%s : F학점\n", subject[i]);
					break;
				}
			}
			System.out.println();
		}
		for (int cnt = 0; cnt < score.length; cnt++) {
			System.out.printf("%d 번째 학생\n총점 : %d, 평균 : %.2f\n", cnt, score[cnt][3], (float)score[cnt][3] / 3);
		}
	}

}
