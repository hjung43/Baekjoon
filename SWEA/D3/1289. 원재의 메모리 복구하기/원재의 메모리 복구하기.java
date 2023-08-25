import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수 입력
		// 테스트 케이스 만큼 반복
		for (int t = 1; t <= T; t++) {
			char[]memory = (sc.next()).toCharArray(); //원래 메모리 입력
			int[] newM = new int[memory.length]; //새로운 메모리 생성(모든 인덱스 0으로 초기화)
			int result = 0; //결과값(고치는 수)저장할 변수
			
			for(int i=0; i<memory.length; i++) {
				if(memory[i]-'0' != newM[i]) { //원래 메모리와 새로운 메모리의 같은 인덱스 값이 다르다면
					result++; //고치기
					for(int j=i;j<memory.length; j++) { //새로운 메모리의 인덱스를 지정한 곳 부터 모두 같은수로 바꾼다
						newM[j] = memory[i]-'0';
					}
				}
			}
			System.out.printf("#%d %d\n",t,result); //결과값 출력
		}
	}
}