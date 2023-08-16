import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		//테스트 케이스 10번 반복하기
		for (int t = 1; t <= T; t++) {
			Stack<Character> stack = new Stack<>(); //괄호담을 스택 생성
			String str = sc.next(); //괄호 문자열로 입력받기
			int n = str.length();   //괄호 개수
			int laser = 0; // 레이저 개수
			int rod = 0; //각 레이저가 자른 쇠막대 개수 (=레이저 괄호를 제외한 여는 괄호 개수)
			int total = 0; //총 쇠막대를 자른 횟수
			boolean openBracket = false; //직전 괄호 여닫힘 유무
			//괄호 개수 만큼 반복
			for(int i=0; i<n; i++) {
				char c = str.charAt(i); //괄호 문자로 나누기
				//레이저 개수와 잘린 쇠막대 개수 세기
				if(c==')') {   //닫는 괄호일때
					rod--;     //쇠막대 개수 -1
					if('('==stack.pop() && openBracket) {//top이 여는 괄호이고 c이전의 괄호가 닫는 괄호가 아니였을때
														 //만약 ))처럼 앞 괄호가 저장되지 않는 닫는괄호였다면 레이저로 세면 안됨 
						laser++;  //레이저 개수+1
						total += rod; // 총 막대 수 = +현재 까지 쇠막대 개수
					}
					openBracket = false;  //닫힌 괄호
				}else { //닫는괄호가 아닐때
					stack.push(c); //스택에 저장
					rod++; //쇠막대수 +1
					openBracket = true; //열린 괄호
				}
			}
			//결과 저장하는 변수
			int result = n/2 -laser +total; //총 괄호수/2 - laser = 원래있던 쇠막대수 + 쇠막대를 자른횟수 => 전체 쇠막대 수
			System.out.printf("#%d %d\n",t,result);
		}
	}
}