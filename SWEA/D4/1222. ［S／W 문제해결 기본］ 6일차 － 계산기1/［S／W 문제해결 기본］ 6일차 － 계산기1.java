import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트 케이스 10번 반복
		for(int t=1; t<=10; t++) {
			int l = sc.nextInt(); //계산식 길이 입력
			String str = sc.next(); //계산식 입력
			Stack<Character> st = new Stack<>(); //계산식 후위표현식으로 바꾸기 위한 스택
			String back = ""; //후위표현식으로 바뀐 계산식 담을 문자열
			//계산식 후위 표현식으로 바꾸기
			for(int i=0; i<l; i++) { //계산식 길이 만큼 반복
				if(str.charAt(i) != '+')  //i인덱스 문자가 숫자라면
					back += str.charAt(i); //문자열에 추가
				else {  //i인덱스의 문자가 +라면
					if(st.isEmpty()) //스택이 비었을땐
						st.push(str.charAt(i));  //그냥 +저장
					else {  //비지 않았을땐
						back += st.pop();  //저장된 +꺼내서 문자열에 저장
						st.push(str.charAt(i)); //스택에 현재+ 저장
					}
				}	
			} back += st.pop(); //마지막에 스택에 담겨있는 +까지 문자열에 저장
			Stack<Integer> r = new Stack<>();  //후위표현식 계산할 스택
			//후위 표현식 계산하기
			for(int i =0; i<l; i++) { //계산식 길이만큼 반복
				if(back.charAt(i)!= '+') {  //후위표현식의 i인덱스 문자가 숫자라면
					r.push(back.charAt(i)-'0'); //스택에 정수로 넣기
				}else {  //후위표현식의 i인덱스 문자가 +라면
					int b = r.pop();  //스택의 현재 top과
					int a = r.pop();  //그다음 top을 꺼내
					r.push(a+b);  //더한 후 다시 스택에 저장
				}
			}
			//결과로 스택에 마지막으로 저장되어 있는 값을 꺼내 출력
			System.out.printf("#%d %d\n",t,r.pop());
		}
	}
}