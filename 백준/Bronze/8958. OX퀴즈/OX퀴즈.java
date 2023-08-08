import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트케이스 개수 받기
		//테스트케이스만큼 반복하기
		for (int t = 0; t < T; t++) { 
			String ox = sc.next(); //OX퀴즈 결과 받기
			int[] score = new int[ox.length()]; //각 문제별 점수 저장하는 배열
			//문제수 만큼 반복해서 배열에 점수저장
			for (int i = 0; i < ox.length(); i++) {
				if (ox.charAt(i) == 'O') { //문제를 맞았을때
					if (i == 0) { //첫번째 문제는 1점
						score[i] = 1;
					} else {  //나머지 문제는 앞 문제점수 +1점
						score[i] = score[i - 1] + 1;
					}
				} else { //문제를 틀렸을때 0점
					score[i] = 0;
				}
			}
			int sum = 0; //전체 점수 저장하는 변수
			//점수 배열을 통해 전체점수 찾기
			for (int i = 0; i < score.length; i++) {
				sum += score[i];
			}
			System.out.println(sum);
		}
	}
}