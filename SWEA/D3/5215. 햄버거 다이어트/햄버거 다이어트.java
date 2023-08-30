import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); //재료의 수
			int k = sc.nextInt(); //제한 칼로리
			int[][]hb = new int[n][2]; //재료 정보 담을 배열
			for(int i=0; i<n; i++) {
				hb[i][0] = sc.nextInt(); //민기의 맛에 대한 점수
				hb[i][1] = sc.nextInt(); //재료의 칼로리
			}
			int result = 0;
			for(int i=0; i<(1<<n); i++) { //i는 이진법으로 0000..(n자리수)부터 1111..까지 모든 부분집합을 나타냄
				int kSum = 0;  //각 집합 당 칼로리의 합
				int tSum = 0;  //각 집합 당 맛에 대한 점수의 합
				for(int j=0; j<n; j++) { //j는 1을 n번 왼쪽으로 밀면서 i에 있는 1찾기
					if((i & (1<<j)) > 0) { //i의 n-j의 인덱스 자리가 1이면
						kSum += hb[j][1];  //칼로리의 합 더하기
						tSum += hb[j][0];  //맛에 대한 점수 더하기
					}
				}
				if(kSum<=k && tSum>result) { //칼로리의 합이 k보다 작고 맛에대한 점수가 가장큰값 찾기
					result = tSum;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}

}