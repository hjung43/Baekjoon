import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

			
			String str = sc.next(); //계산식 입력
			int l = str.length(); //계산식 길이 입력
			Stack<Character> st = new Stack<>(); //계산식 후위표현식으로 바꾸기 위한 스택
			String back = ""; //후위표현식으로 바뀐 계산식 담을 문자열
			int bcnt = 0;
			//계산식 후위 표현식으로 바꾸기
			for(int i=0; i<l; i++) { //계산식 길이 만큼 반복
				if(str.charAt(i) != '+' && str.charAt(i) != '*' && str.charAt(i) != '(' && str.charAt(i) != ')'&& str.charAt(i) != '-'&& str.charAt(i) != '/')  //i인덱스 문자가 숫자라면
					back += str.charAt(i); //문자열에 추가
				else {  //i인덱스의 문자가 숫자가 아니라면
					if(st.isEmpty() || str.charAt(i) == '(' ) //스택이 비었거나 str.charAt(i)가 (일땐
						st.push(str.charAt(i));  //스택에 기호 저장
					else if(str.charAt(i) == '*' || str.charAt(i) == '/') {
						if(st.peek() == '*' || st.peek() == '/') {
							back += st.pop();  //저장된 *또는 /꺼내서 문자열에 저장
							st.push(str.charAt(i)); //스택에 현재 기호 저장
						}else if(str.charAt(i) != '*' || str.charAt(i) != '/'){
							st.push(str.charAt(i)); //스택에 현재 기호 저장
						}
					}
					else if (str.charAt(i) == '+' || str.charAt(i) == '-'){  //+ -일때
						if(st.peek() == '*' || st.peek() == '/') {  //현재 top이 * /라면
							//스택이 비지 않았을 때 top이 + 또는 (가 될때 까지 pop하여 문자열 저장
							while(!(st.isEmpty()) && st.peek()!='+' && st.peek()!='-' && st.peek()!='(')
								back += st.pop();
						}
						if(st.isEmpty() || st.peek() == '(') //스택이 비었거나 현재 top가 (이면
							st.push(str.charAt(i)); //스택에 현재 기호 저장
						else if( st.peek() == '+' || st.peek()=='-'){ //현재 top가 +이면
							back += st.pop();  //저장된 +또는 -꺼내서 문자열에 저장
							st.push(str.charAt(i)); //스택에 현재 기호 저장
						}
					}else if(str.charAt(i) == ')'){ //str.charAt(i)가 닫는 괄호 일떄
						bcnt++; //괄호수 세기
						//여는 괄호 만나기 전까지 pop하여 문자열 저장
						while(st.peek()!='(')
							back += st.pop();
						st.pop(); //여는괄호는 저장없이 pop
					}
				} //else(i인덱스의 문자가 숫자가 아닐때  else문)	
			} //for (계산식 길이 만큼 반복하는 for문)
			//스택에 남아있는 모든 기호 문자열에 저장
			while (!st.isEmpty()) 
				back += st.pop(); 
			System.out.println(back);
	}
}