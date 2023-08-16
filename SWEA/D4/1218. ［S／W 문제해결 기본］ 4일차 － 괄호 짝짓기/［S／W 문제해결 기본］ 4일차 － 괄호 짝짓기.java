import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트 케이스 10번 반복하기
		for (int t = 1; t <= 10; t++) {
			Stack<Character> stack = new Stack<>(); //숫자를 담을 스택 생성
			int k = sc.nextInt(); //괄호 개수 입력
			String str = sc.next(); //괄호 문자열로 입력받기
			//괄호 개수 만큼 반복
			for(int i=0; i<k; i++) {
				char c = str.charAt(i); //괄호 문자로 나누기
				if(c==')') { //닫는 소괄호 일때 일때
					if('('!=stack.peek()){ //stack의 top이 (가 아니면
						break;  //멈추기
					}else  //맞으면
						stack.pop(); //(지우기
				}else if(c=='}') { //닫는 중괄호 일때
					if('{'!=stack.peek()) { //stack의 top이 {가 아니면
						break;  //멈추기
					}else  //맞으면
						stack.pop(); //{지우기
				}else if(c==']') { //닫는 대괄호 일때
					if('['!=stack.peek()){ //stack의 top이 [가 아니면
						break;  //멈추기
					}else  //맞으면
						stack.pop(); //[지우기
				}else if(c=='>') { //닫는 화살괄호 일때
					if('<'!=stack.peek()){ //stack의 top이 <가 아니면
						break;   //멈추기
					}else  //맞으면
						stack.pop(); //<지우기
				}else { //닫는괄호가 아닐때
					stack.push(c); //스택에 넣기
				}
			}
			if(stack.isEmpty())  //스택이 비어있으면
				System.out.printf("#%d %d\n",t,1);  //모두 짝이 맞음 -> 1출력
			else //스택에 값이 남아있다면
				System.out.printf("#%d %d\n",t,0);  //짝이 맞지 않음 -> 0출력
		}
	}
}