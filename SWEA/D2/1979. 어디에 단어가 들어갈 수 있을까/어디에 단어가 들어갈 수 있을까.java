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
			 int[]wc = new int[n+1]; //단어퍼즐에 들어갈 수 있는 모든 단어글자수 저장할 배열
			 int w = 0; //단어글자수 저장할 변수
			 //배열에 단어퍼즐 넣기
			 for(int i=0; i<n; i++) {
				 for(int j=0; j<n; j++) {
					 word[i][j] = sc.nextInt();
				 }
			 }
			 for(int i=0; i<n; i++) {
				 wc[w]++;
				 w=0;
				 for(int j=0; j<n; j++) {
					 if(word[i][j]==1) {
						 w++;
					 }else {
						 wc[w]++;
						 w = 0;
					 }
				 }
			 }
			 
			 for(int i=0; i<n; i++) {
				 wc[w]++;
				 w = 0;
				 for(int j=0; j<n; j++) {
					 if(word[j][i]==1) {
						 w++;
					 }else {
						 wc[w]++;
						 w = 0;
					 }
				 }
			 }wc[w]++;
			 System.out.printf("#%d %d\n",t+1,wc[m]);
		 }
	}
}