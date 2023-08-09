import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int T = sc.nextInt(); //테스트케이스개수
		 //테스트케이스만큼 반복
		 for(int t=0; t<T; t++) {
			 int n = sc.nextInt(); //파리가 있는 배열 크기
			 int m = sc.nextInt(); //파리채 크기
			 int[][]fly = new int[n][n]; //파리가 있는 배열
			 int max = 0; //최대 잡을 수 있는 파리개수 저장하는 변수
			 //배열에 값 넣기
			 for(int i=0; i<n; i++) {
				 for(int j=0; j<n; j++) {
					 fly[i][j] = sc.nextInt();
				 }
			 }
			 //파리가 있는 배열에서 파리채 크기 만큼씩 잡을 수 있는 모든 파리개수 파악하기
			 for(int i=0; i<n-(m-1); i++) {
				 for(int j=0; j<n-(m-1); j++) {
					 int sum =0; //한번에 잡을 수 있는 파리수 저장하는 변수
					 for(int k=0; k<m; k++) {
						 for( int l=0; l<m; l++){
							 sum += fly[i+k][j+l];
						 }
					 }
					 if(sum>max) { //한번에 잡을 수 있는 파리 수 중 가장 큰값 찾기
						 max = sum;
					 }
				 }
			 }
			 System.out.printf("#%d %d\n",t+1,max);
		 }
	}
}