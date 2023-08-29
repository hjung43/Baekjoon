import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt(); //켜져있는지 뒤에서 부터 확인할 비트 수
			int m = sc.nextInt(); //비트 확인할 정수
			int cnt = 0; //총 켜져있는 비트 수 저장한 변수
			//켜져있는 비트 수 뒤에서 부터 찾기
			for(int i=0; i<n; i++) { //확인할 비트 수 만큼 반복
				if((m & (1<<i)) >0) { //1의 비트를 왼쪽으로 밀면서(1,10,100...)비트1이 있는 자리에 m에도 비트 1이 있는지 &연산자로 확인
					cnt++; //있으면  개수 추가
				}
			}
			if(cnt == n) { //켜져있는 비트수가 n과 같으면 
				System.out.println("#"+t+" "+"ON"); //on출력
			}else { //적으면
				System.out.println("#"+t+" "+"OFF"); //off출력
			}
		}
	}

}