import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String str = sc.next(); //기립박수 치는 규칙 문자열로 입력
			int clap = 0; // 기립박수 치는 사람수
			int employ = 0; // 고용할 사람 수
			//고용할 사람 수 찾기
			for (int i = 0; i < str.length(); i++) { //문자열 길이 만큼 반복
				if (str.charAt(i) - '0' != 0) { //문자열의 i-1번째 값이 0이 아니면
					if (i <= clap) { //i보다 이미 박수를 치고 있는 사람 수가 많거나 같으면
						clap += str.charAt(i) - '0'; //i값 추가
					} else { //문자열의 i-1번째 값이 0이면
						employ += i - clap; //고용할 사람수 부족한 사람 만큼 추가
						clap += (i-clap)+str.charAt(i)-'0'; //박수치는 사람수 = +고용할 사람 + i-1번째 박수치는사람
					}
				}
			}
			System.out.printf("#%d %d\n",t,employ);

		}
	}
}