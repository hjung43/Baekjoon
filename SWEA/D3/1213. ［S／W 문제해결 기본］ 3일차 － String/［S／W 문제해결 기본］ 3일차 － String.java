import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트 케이스 만큼 반복하기
		for (int t = 1; t <= 10; t++) {
			int T = sc.nextInt(); //테스트 케이스 번호 입력
			String search = sc.next();   //찾을 문자열 받기
			String str = sc.next(); //검색할 문장 받기
			
			int n = str.length(); //검색할 문장 길이
			int m = search.length(); //찾을 문자열 길이
			
			int result = 0;  //찾을 문자열이 총 몇개 들어있는지 저장할 변수
			//패턴매칭을 통해 search몇개 들어있는지 찾기
			for(int i=0; i<n-m+1; i++) {   //0~n-m까지 검색하면 됨 i는 패턴검사의 시작위치
				int cnt = 0;  //똑같은 문자가 몇번 있는지 저장할 변수
				for(int j=0; j<m; j++) {   
					if(str.charAt(i+j) == search.charAt(j)) { //i는 패턴검사의 시작위치
						cnt++;  //str과  search의 문자가 같으면 cnt++
					}
					if(cnt == m) {  //cnt가 찾아야할 문자열의 길이와 같다면 문장에 문자열 발견한것!
						result++;  //결과값에 +1
					}
				}
			}
			System.out.printf("#%d %d\n",T,result);  //결과값 출력
		}
	}
}