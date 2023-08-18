import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine(); //뒤집을 문자열 입력받기
		StringTokenizer st = new StringTokenizer(str, "<>", true); //<,>로 문자열 나누기
		String result = ""; //결과담을 빈 문자열
		
		//다음 토큰이 없을때 까지 반복
		while(st.hasMoreTokens()) {
			String a = st.nextToken(); //a에 다뤄야할 토큰 저장
			if(a.equals("<")) {  //a가 <이면
				while(!a.equals(">")) { //>만나기 직전까지 
					result +=a;  //결과담을 문자열에 토큰 저장 
					a = st.nextToken(); //다음토큰 a에 저장
				}result +=a; //>까지 결과 문자열에 담기
			} else {  //a가 <가 아니면
				StringTokenizer st2 = new StringTokenizer(a, " ", true); //띄어쓰기로 단어 나누기
				//띄어쓰기로 나눈 다음 단어가 없을때 까지 반복
				while(st2.hasMoreElements()) {
					StringBuilder sb = new StringBuilder(); 
					String b = st2.nextToken(); //새 토큰 저장
					sb.append(b); //토큰 StringBuilder에 추가
					result +=sb.reverse(); //토큰 뒤집어서 결과 문자열에 추가
				}
			}
		}System.out.println(result); //결과 출력
	}
}