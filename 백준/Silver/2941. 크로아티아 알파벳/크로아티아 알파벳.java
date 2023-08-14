import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next(); //문자열 받기
		char[] cro = new char[str.length()]; //문자 하나씩 담을 배열
		//문자열 문자로 나눠서 배열에 담기
		for(int i=0; i<str.length(); i++) {
			cro[i] = str.charAt(i);
		}	
		int result = 0; //총 글자수 저장할 변수
		//글자수 파악해서 세기
		for(int i=0; i<str.length(); i++) {
			if(cro[i] == '=' || cro[i]== '-') { //=이나-은 세지 않고 넘어감
				continue;
			}else if(i<str.length()-1 && (cro[i]=='l' || cro[i] =='n') && cro[i+1]=='j') {
				continue;  //i가 총 길이-1보다 작을때 l이나n뒤에 j가 있는 경우 l이나 n은 세지 않고 넘어간다
			}else if(i<str.length()-2 && cro[i] =='d' && cro[i+1]=='z' && cro[i+2]=='=' ) {
				continue; //i가 총 길이-2보다 작고 d이며 d뒤로 z=가 오면  d는 세지않고 넘어간다
			}else {
				result++; //글자수 세기
			}
		}
		System.out.println(result);
	}

}