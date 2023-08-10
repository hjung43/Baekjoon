import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//10번 반복
		for (int t = 0; t < 10; t++) {
			int T = sc.nextInt(); // 테스트 케이스 번호
			int[][] nums = new int[100][100]; //100*100배열
			int result = 0; //가장 큰 합 저장할 변수
			//배열받기
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					nums[i][j] = sc.nextInt();
				}
			}
			//행우선 순회 하면서 행의합 찾아 가장 큰 값 result에 저장하기
			for (int i = 0; i < 100; i++) {
				int sum =0; //각 행의 합 저장할 변수
				for (int j = 0; j < 100; j++) {
					for (int k = 0; k < 100; k++) { 
						if(i==j) {
							sum += nums[i][k];  //열 고정, 행 순회하면서 행의 합 찾기
						}
						if(sum>result) {  //합이 result보다 크면 result에 sum 넣기
							result = sum; 
						}
					}					
				}
			}
			//열 우선순회 하면 열의 합 찾아 가장 큰 값 result와 비교해 더 큰 값 저장하기
			for (int i = 0; i < 100; i++) {
				int sum =0; //열의 합 저장할 변수
				for (int j = 0; j < 100; j++) {
					for (int k = 0; k < 100; k++) {
						if(i==j) {
							sum += nums[k][i];  //행고정,열 순회하며 열의 합 구하기
						}
						if(sum>result) { //합이 result보다 크면 result에 sum 넣기
							result = sum; 
						}
					}					
				}
			}
			//왼쪽위부터 오른쪽 아래까지 내려오는 대각선 합 구하고 result와 비교하기
			int sum = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if(i==j) {
						sum = nums[i][j]; //[0,0],[1,1] ... 과 같은 대각선값 찾아서 합 구하기
					}
					if(sum>result) { //합이 result보다 크면 result에 sum 넣기
						result = sum; 
					}
				}
			}
			//왼쪽 아래부터 오른쪽 위까지 올라가는 대각선 합 구하고  result와 비교하기
			sum = 0;
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if(i+j == 4) {
						sum = nums[i][j]; //[4,0],[3,1]...과 같은 대각선 값 찾아서 합 구하기
					}
					if(sum>result) {  //합이 result보다 크면 result에 sum 넣기
						result = sum; 
					}
				}
			}
			System.out.printf("#%d %d\n",T,result); //가장 큰 합 출력하기
		}
	}
}