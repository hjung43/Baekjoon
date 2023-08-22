import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트 케이스 10번 반복하기
		for (int t = 1; t <= 10; t++) {
			LinkedList<Integer> list = new LinkedList<>(); //숫자담을 리스트 생성
			int n = sc.nextInt(); // 원본 암호문의 길이
			//원본 암호문 입력받기
			for (int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}
			int m = sc.nextInt(); // 명령어의 개수
			//명령어 실행하기
			for (int i = 0; i < m; i++) {
				String pw = sc.next(); //암호시작 신호 받기
				if (pw.equals("I")) {  //암호 시작신호가 I라면
					int x = sc.nextInt(); //넣어야할 위치 입력
					int y = sc.nextInt(); //넣아야할 숫자개수 입력
					//원본암호문에 명령어 실행
					for (int j = 0; j < y; j++) { //넣어야 할 숫자 개수만큼 반복
						list.add(x, sc.nextInt()); //x인덱스(받은 위치의 다음 인덱스니까 -1안함)에 넣을 숫자 입력받아 넣기
						x++; //인덱스+1
					}
				}else if(pw.equals("D")) { //암호 시작신호가 D라면
					int x = sc.nextInt(); //지워야할 위치 입력
					int y = sc.nextInt(); //지워야할 숫자개수 입력
					//원본암호문에 명령어 실행
					for (int j = 0; j < y; j++) { //넣어야 할 숫자 개수만큼 반복
						list.remove(x); //x인덱스(받은 숫자의 다음 위치니까 -1안함)삭제하기
					}
				}else {
					int y = sc.nextInt();
					for(int j = 0; j < y; j++) {
						list.add(sc.nextInt());
					}
				}
			}
			//10번 까지만 출력하기
			System.out.print("#"+t+" ");
			for(int i=0; i<10; i++) {
				System.out.print(list.get(i)+" ");
			}
			System.out.println();
		}
	}
}