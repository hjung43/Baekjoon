import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); // 배열의 세로크기
			int m = sc.nextInt(); // 배열의 가로크기
			int[][] pw = new int[n][m]; //암호 담을 배열
			//암호 배열에 담기
			for (int i = 0; i < n; i++) {
				String str = sc.next();
				for (int j = 0; j < m; j++) {
					pw[i][j] = str.charAt(j) - '0';
				}
			}
			
			int[] fPw = new int[8]; //해석한 암호 담을 배열
			//암호 해석하기
			loop1: for (int i = 0; i < n; i++) { 
				for (int j = m - 1; j >= 0; j--) {  //열만 뒤에서 반대로 순회 (이진숫자가 항상 1로 끝나서 뒤에서부터 1찾기)
					if (pw[i][j] == 1) { //현재 위치가 1이면
						int idx = 0; //해석한 암호 인덱스 저장할 변수
						//숫자 8개로 쪼개기
						for (int k = 0; k < 56; k+=7) { //7개씩 8번 반복
							int sj = j-k; //j값에서 -7씩 감소
							int cntN = 0; //1의 개수를 세기위한 변수
							int cntZ = 0; //0의 개수를 세기위한 변수
							String password = ""; //해독을 위한 코드 저장할 문자열
							//숫자 7개씩 탐색하며 0과 1이 연속되는 개수 세기
							for (int l = 0; l < 7; l++) {
								if (pw[i][sj - l] == 1) { //1이면
									if(pw[i][sj-l+1] == 0 && cntZ !=0) { //이전 숫자가 0이었고 현재 0이 연속으로 나온 개수가 0이 아닐때										
										password += (char) (cntZ + '0'); // 0의 개수 해독코드에 문자로 저장
									}
									cntZ=0; //연속된 0의개수 초기화
									cntN++; //1의 개수 +1
									
								} else { //0이면
									if(pw[i][sj-l+1] != 0 && cntN !=0) { //이전 숫자가 0이 아니고 현재 1이 연속으로 나온 개수가 0이 아닐때
										password += (char) (cntN + '0'); //1의 개수 해독코드에 문자로 저장
									}
									cntN = 0; //연속된 1의 개수0으로 초기화
									cntZ++; //연속된 0의 개수 +1
								}
							}
							password += (char) (cntZ + '0'); //숫자 하나의 암호코드마다 제일 첫 숫자는 0이므로 0의 연속된 개수 해독코드에 저장
							//저장된 해독코드로 숫자 찾기
							if (password.equals("1132"))  //주어진 해독코드를 거꾸로 작성해서 비교(뒤에서 부터 찾았기 때문)
								fPw[7 - idx] = 0; //해당 코드와 같으면 해당 숫자 해석한 암호 배열의 뒤에서 부터 저장
							if (password.equals("1222"))
								fPw[7 - idx] = 1;
							if (password.equals("2212"))
								fPw[7 - idx] = 2;
							if (password.equals("1141"))
								fPw[7 - idx] = 3;
							if (password.equals("2311"))
								fPw[7 - idx] = 4;
							if (password.equals("1321"))
								fPw[7 - idx] = 5;
							if (password.equals("4111"))
								fPw[7 - idx] = 6;
							if (password.equals("2131"))
								fPw[7 - idx] = 7;
							if (password.equals("3121"))
								fPw[7 - idx] = 8;
							if (password.equals("2113"))
								fPw[7 - idx] = 9;
							idx++;
						}
						break loop1;
					}
				}
			}
			//(홀수 자리의 합 x 3) + (짝수 자리의 합)
			int dc = (fPw[0]+fPw[2]+fPw[4]+fPw[6])*3+fPw[1]+fPw[3]+fPw[5]+fPw[7];
			int result = 0;
			//암호 유효한지 확인하고 출력
			if(dc%10!=0) { //10의 배수가 아니면
				System.out.println("#"+t+" "+0); //0출력
			}else { //10의 배수이면
				for(int i=0; i<fPw.length; i++) {
					result += fPw[i];  //해석한 암호배열의 합 구하기
				}
				System.out.println("#"+t+" "+result); //합 출력
			}
		}
	}

}