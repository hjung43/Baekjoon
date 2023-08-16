import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); //테스트 케이스 개수 입력
		String enter = sc.nextLine(); //다음 nextLine에서 엔터도 입력으로 먹혀서 엔터 값 따로주기
		//테스트케이스 만큼 반복
		for (int t = 1; t <= T; t++) {
			String str = sc.nextLine();  //문자열 띄어쓰기 까지 같이 입력받기
			int wnum = 1;  //문자열 내 단어 개수 저장할 변수(띄어쓰기 개수 +1이라 1부터 시작)
			//문자열 내 띄어쓰기 개수 찾기
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) ==' ') { //문자열 내 문자중 빈 문자가 있으면 
					wnum++; //띄어쓰기 개수 추가
				}
			}
			String [] s = str.split(" "); //문장 띄어쓰기로 나눠서 각 단어 배열에 넣기
			//단어수만큼 반복해서 결과 출력하기
			for(int i=0; i<wnum; i++) {
				StringBuilder sb = new StringBuilder(); 
				sb.append(" "+s[i]); //스트링빌더에 단어넣기 (뒤집을꺼라 단어 앞에 띄어쓰기 추가)
				sb.reverse(); //단어 뒤집기
				System.out.print(sb.toString());  //제일 앞 단어부터 뒤집어져서 출력
			}
		}
	}
}