import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); //자연수 개수
			int k = sc.nextInt(); //만들고자 하는 합의 값
			int[]arr = new int[n]; //자연수 담을 배열
			//자연수 담기
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			int sum = 0;  //부분집합의 합
			int result = 0; //만들고자 하는 합에 부합하는 부분집합의 개수
			//합이 k인 부분집합 찾기
			for(int i=0; i<(1<<n); i++) { //i는 이진법으로 0000..(n자리수)부터 1111..까지 모든 부분집합을 나타냄
				for(int j=0; j<n; j++) { //j는 1을 n번 왼쪽으로 밀면서 i에 있는 1찾기
					if((i & (1<<j)) > 0) { //i의 n-j의 인덱스 자리가 1이면
						sum += arr[j]; //j인덱스에 있는 자연수의 합 구하기
					}
				}
				if(sum == k) { //집합의 합이 k이면
					result++; //개수+1
				}
				sum=0; //합 = 0으로 초기화
			}
			System.out.println("#"+t+" "+result); //결과값 출력
		}
	}

}