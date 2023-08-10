import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수
		
		//테스트 케이스만큼 반복
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();   //판 크기 받기
			char[][]pan = new char[n][n];  //판 크기에 맞춰 2차원 문자배열 만들기
			int result =0;
			//돌 위치 받기
			for(int i=0; i<n; i++) {
				String doll = sc.next();  //문자열로 먼저 받기
				for(int j=0; j<n; j++) {
					pan[i][j] = doll.charAt(j); //문자로 나누어서 배열에 저장
				}
			}
			loop1:for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(pan[i][j]=='o') {
						int rsum = 1;  //각 행의 돌의 개수의 합
						int csum = 1;  //각 열의 돌의 개수의 합
						int usum = 1; //왼쪽 아래에서 오른쪽 위까지 대각선 위 돌의 합
						int dsum = 1; //왼쪽 위에서 오른쪽 아래까재 대각선 위 돌의 합
						int starti = i;
						int startj = j;
						while(j<n-1 && pan[i][j+1]=='o') {
							rsum++;
							j++;
						}
						j = startj;
						while(i<n-1 && pan[i+1][j]=='o') {
							csum++;
							i++;
						}
						i = starti;
						while(j<n-1 && i<n-1 && pan[i+1][j+1]=='o') {
							dsum++;
							i++;
							j++;
						}
						i = starti;
						j = startj;
						while(i>0 && j<n-1 && pan[i-1][j+1]=='o') {
							usum++;
							i--;
							j++;
						}
						i = starti;
						j = startj;
						if(rsum==5 || csum==5 || usum==5 || dsum==5) {
							System.out.println("#"+t+" "+"YES");
							result = 1;
							break loop1;
						}
						
					}
				}
			}
			if(result ==0) {
				System.out.println("#"+t+" "+"NO");
			}
		}
	}
}