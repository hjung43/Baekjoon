import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트 케이스 10번 반복
		for(int t=0; t<10; t++) {
			int T = sc.nextInt(); //테스트 케이스 번호 받기
			int n = sc.nextInt(); //제곱할 밑수 입력
			int m = sc.nextInt(); //지수 입력
			System.out.printf("#%d %d\n",T,power(n,m)); //거듭제곱 함수 호출 후 출력
		}
	}
	//거듭제곱 함수
	public static int power (int n, int m) { //n=밑수 , m=지수
		if(m==1) return n;      //지수가 1이되면 밑수 리턴
		return n*power(n,m-1);  //재귀함수 사용
								//2의5승 = 2*2의4승 -> 2의4승 = 2*2의3승 ... 
	}
}