import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt(); //점원의 수
			int b = sc.nextInt(); //선반의 높이
			int[]tower = new int[n]; //점원의 키 담을 배열
			//배열에 점원 키 담기
			for(int i=0; i<n; i++) {
				tower[i] = sc.nextInt();
			}
			int result = Integer.MAX_VALUE; //결과값 저장할 변수(만든 탑의높이-선반의 높이 중 가장 작은 수)
			//선반보다 높은 탑 중에서 가장 작은 탑 찾기
			for(int i=0; i<(1<<n); i++) { //n의 부분집합 찾기
				int sum = 0; //부분집합의 키 모두 더한 값
				for(int j=0; j<n; j++) { //1을 j번 왼쪽으로 밀어서 해당 원소 사용하는지 여부 확인
					if((i & (1<<j)) >0) {
						sum += tower[j]; //사용하면 합에 추가
					}
				}
				//합이 선반높이 이상이고 탑에서 선반을 뺀 값이 현재 결과값 보다 작으면
				if(sum>=b && sum-b<result) {
					result = sum - b; //결과값 변경
				}
			}
			//출력
			System.out.printf("#%d %d\n",t,result);
			
		}
		

	}

}