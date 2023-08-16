import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 수 입력
		//테스트 케이스 만큼 반복하기
		for (int t = 1; t <= T; t++) {
			Stack<Integer> stack = new Stack<>(); //숫자를 담을 스택 생성
			int k = sc.nextInt(); //숫자 개수 입력
			//숫자 개수 만큼 반복
			for(int i=0; i<k; i++) {
				int n = sc.nextInt(); //숫자 입력받기
				if(n!=0) {  //숫자가 0이 아니면
					stack.push(n); //스택에 저장
				}else {   //숫자가 0이면
					stack.pop();  //top에 있는 숫자 지우기
				}
			}
			int sum = 0; //스택에 남은 숫자의 합 저장할 변수
			//스택에 남은 숫자의 합 구하기
			for(int i=0; i<stack.size(); i++) {
				sum += stack.get(i);
			}
			System.out.printf("#%d %d\n",t,sum); //결과값 출력
		}
	}
}