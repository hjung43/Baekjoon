import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 //테스트케이스만큼 반복
		 for(int t=0; t<10; t++) {
			 int T = sc.nextInt(); //테스트 케이스 번호 입력받기
			 int[][] ladder= new int[100][100]; //사다리 배열
			 int starti = 0; //사다리 시작점 저장하는 변수
			 //배열에 사다리 넣기
			 for(int i=0; i<100; i++) {
				 for(int j=0; j<100; j++) {
					 ladder[i][j] = sc.nextInt();
				 }
			 }
			 //반복문을 이용해 사다리 타기
			 for(int i=0; i<100; i++) { //첫번째 행에 있는 1(시작점) 찾기
				 if(ladder[0][i]==1) {  //첫번째 행에 i번째가 1이라면
					 starti = i;        //시작점 변수에 저장 (나중에 출력 & 다음 시작점 찾을때 사용)
					 //열을 변화하며 내려가기
					 for(int j=0; j<100; j++) {
						 if(i<99 && ladder[j][i+1] == 1) { //오른쪽으로 길이 있을 때(인덱스 99까지 있어서 99보단 작아야됨)
							 while(i<99 && ladder[j][i+1]==1) { //길이 막힐때 까지 오른쪽으로 이동 
								 i++;
							 } 
						 }else if(i>0 && ladder[j][i-1]==1) { //왼쪽으로 길이 있을 때(인덱스 0까지 있어서 0보단 작아야됨)
							 while(i>0 && ladder[j][i-1]==1) {  //길이 막힐때 까지 왼쪽으로 이동
								 i--;
							 }
						 }
						 if(ladder[j][i]==2) {  //2(X)를 만나면 시작점 출력
							 System.out.printf("#%d %d\n",T,starti);
						 }
					 }i = starti+1; //현재 시작점의 바로 오른쪽 부터 새로운 시작점 찾기위해 초기화
				 }
			 }		 
		 }
	}
}