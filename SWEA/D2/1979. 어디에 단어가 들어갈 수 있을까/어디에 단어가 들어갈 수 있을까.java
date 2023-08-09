import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int T = sc.nextInt(); //테스트케이스개수
		 //테스트케이스만큼 반복
		 for(int t=0; t<T; t++) {
			 int n = sc.nextInt(); //단어퍼즐 크기 입력받기
			 int m = sc.nextInt(); //들어갈 단어크기 입력받기
			 int[][]word = new int[n][n]; //단어퍼즐 배열
			 int[]wcnt = new int[n+1]; //단어퍼즐에 들어갈 수 있는 모든 단어글자수 저장할 카운트배열
			 int w = 0; //단어글자수 저장할 변수
			 //배열에 단어퍼즐 넣기
			 for(int i=0; i<n; i++) {
				 for(int j=0; j<n; j++) {
					 word[i][j] = sc.nextInt();
				 }
			 }
			 //행우선 순회를 통해 가로 단어글자수 파악후 캬운트 배열에 저장
			 for(int i=0; i<n; i++) {
				 wcnt[w]++;  //행이 1로 끝났을때 카운트 배열 저장을 위해
				 w=0;		 // 단어글자수 초기화
				 for(int j=0; j<n; j++) { 
					 if(word[i][j]==1) {  //1일때 단어글자수 +1
						 w++;
					 }else {  //0일때 이때까지 모인 단어글자수 카운트 배열에 저장
						 wcnt[w]++;
						 w = 0;
					 }
				 }
			 }
			//열우선 순회를 통해 가로 단어글자수 파악후 캬운트 배열에 저장
			 for(int i=0; i<n; i++) {
				 wcnt[w]++; //열이 1로 끝났을때 카운트 배열 저장을 위해
				 w = 0;		// 단어글자수 초기화
				 for(int j=0; j<n; j++) { 
					 if(word[j][i]==1) { //1일때 단어글자수 +1
						 w++;
					 }else {  //0일때 이때까지 모인 단어글자수 카운트 배열에 저장
						 wcnt[w]++;
						 w = 0;
					 }
				 }
			 }wcnt[w]++; //모든 배열의 마지막이 1로 끝났을때 카운트 배열 저장을 위해
			 System.out.printf("#%d %d\n",t+1,wcnt[m]);
		 }
	}
}