import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int m1 = sc.nextInt();  //첫번째 날짜 월
			int d1 = sc.nextInt();  //첫번째 날짜 일
			int m2 = sc.nextInt();  //두번째 날짜 월
			int d2 = sc.nextInt();  //두번째 날짜 일
			int day1 = 0;   //첫번째 날짜 까지 모든 일수 더한 값 저장할 변수
            //1월1일 부터 첫번째 날짜까지의 모든 일 수
			for(int i=0; i<m1-1; i++) {
				day1 += month[i];
			}
			day1 += d1;
			int day2 = 0;  //두번째 날짜 까지 모든 일 수 더한 값 저장할 변수
             //1월1일 부터 두번째 날짜 까지의 모든 일 수
			for(int i=0; i<m2-1; i++) {
				day2 += month[i];
			}
			day2 += d2;
			
			System.out.printf("#%d %d\n",t,day2-day1+1);
		}
	}
}