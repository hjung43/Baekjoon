import java.util.Scanner;

public class Solution {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  //테스트 케이스 수 입력
        //테스트 케이스 만큼 반복
        for (int t = 1; t <= T; t++) {
        	int result = 1; //결과값 저장할 변수
        	int[][]arr = new int [9][9];  //스도쿠판 저장할 배열
        	//스도쿠판 입력하기
        	for (int i = 0; i < 9; i++) {
        		for (int j = 0; j < 9; j++) {
        			arr[i][j] = sc.nextInt();
				}
			}
        	//칸마다 가로세로에 겹치는 수 있는지 확인하기
        	loop1 : for (int i = 0; i < 9; i++) {
        		for (int j = 0; j < 9; j++) {
        			int rCnt = 0; //가로줄 숫자 겹치는 개수 저장할 변수
        			int cCnt = 0; //세로줄 숫자 겹치는 개수 저장할 변수
        			
        			for (int k = 0; k < 9; k++) {
						if(arr[i][j] == arr[i][k]) { //가로줄에 숫자가 겹치면
							rCnt++; //+1
						}
						if(rCnt>1) { //cnt가 1보다 크면 (자기자신도 세기 때문에 1개는 무조건 나와야 함)
							result = 0; //결과값 바꾸기
							break loop1; //반복문 종료
						}
						if(arr[j][i]==arr[k][i]) { //세로줄에 숫자가 겹치면
							cCnt++; //+1
						}
						if(cCnt>1) { //cnt가 1보다 크면 (자기자신도 세기 때문에 1개는 무조건 나와야 함)
							result = 0; //결과값 바꾸기
							break loop1; //반복문 종료
						}
					}
				}
			}
			//3*3작은 격자 순회하기
			loop2: for(int i=0; i<3; i++) {
				for(int j =0; j<3; j++) {
					int[]count = new int[10]; //스도쿠 안에 있는 숫자 셀  카운트 배열
					for(int k = i*3; k<i*3+3; k++) {
						for(int l = j*3; l<j*3+3; l++) {
							count[arr[k][l]]++; //각 숫자의 개주 저장
						}
					}
					//카운드 배열 순회
					for(int k = 1; k<10; k++) {
						if(count[k]==0) { //카운트 배열 1~9인덱스 중 값이 0이 있다면		
							result = 0; //결과값 바꾸기
							break loop2; //반복문 종료
						}
					}
				}
			}
			//결과값 출력하기
			System.out.println("#"+t+" "+result);
		}
        
    }
}