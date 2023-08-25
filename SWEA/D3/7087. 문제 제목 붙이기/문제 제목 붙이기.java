import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수 입력
		// 테스트 케이스 만큼 반복
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); //문제 제목 개수 입력
			String[] qName = new String[n]; //제목 개수 크기 만큼의 배열 생성
			//배열에 제목 입력하기
			for (int i = 0; i < n; i++) {
				qName[i] = sc.next();
			}
			char al = 'A'; //알파벳 순서대로 담을 변수
			int result = 0; //결과값(사용할 수 있는 최대 문제제목 개수)담을 변수
			//알파벳이 Z가 될때 까지 반복
			while (al <= 'Z') {
				int cnt = 0; //현재 알파벳으로 시작하는 제목 개수 저장할 변수
				//특정 알파벳(al)으로 시작하는 제목 개수 파악하기
				for (int i = 0; i < n; i++) {
					if (qName[i].charAt(0) == al) { //제목의 첫번째 문자가 al과 같다면
						cnt++; //개수추가
					}
				}
				
				if (cnt != 0) { //특정 알파벳(al)으로 시작하는 제목이 1개 이상 있다면
					result++; //결과값 +1
					al++; //다음 알파벳으로 바꾸기
				}else { //특정알파벳(al)로 시작하는 제목이 없다면
					break; //while 반복문 중단
				}
			}
			//결과값 출력
			System.out.printf("#%d %d\n",t,result);
		}
	}
}