

import java.util.Scanner;

public class Solution {
	static int d; // 보호필름 두께
	static int w; // 보호필름 가로크기
	static int k; // 합격기준
	static int[][] film; //보호필름 정보 저장할 배열
	static int[][] result; //보호필름 용액 넣은 결과 저장할 배열
	static int cnt; //용액을 몇번 넣었는지 셀 변수
	static int ans; //결과값 저장할 변수 (용액을 가장 적게 넣은 경우)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 입력
		for (int t = 1; t <= T; t++) {
			ans = Integer.MAX_VALUE; // 결과값 정수 중 가장 큰 값으로 초기화(최소값 찾기위해)
			cnt = 0; // 용액 넣은 개수 테케마다 0으로 초기화
			d = sc.nextInt(); //보호필름 두께 입력
			w = sc.nextInt(); //보호필름 가로크기 입력
			k = sc.nextInt(); //합격기준 입력
			film = new int[d][w]; //보호필름 담을 배열 크기선언
			result = new int[d][w]; //보호필름에 용액을 넣은 결과 담을 배열 크기 선언
			//보호필름 정보 배열에 입력
			for (int i = 0; i < d; i++) {
				for (int j = 0; j < w; j++) {
					film[i][j] = sc.nextInt();
				}
			}
			test(0); //함수실행
			System.out.println("#" + t + " " + ans); //출력
		}

	}

	public static void test(int idx) {
		if (idx == d) { //인덱스가 d일때
			int total = 0; //각 열마다 연속으로 k번 특성이 반복하는 경우 개수 저장할 변수
			//열우선 순회
			for (int i = 0; i < w; i++) {
				int sumA = 0; //A가 연속으로 몇번 나오는지 확인할 변수
				int sumB = 0; //B가 연속으로 몇번 나오는지 확인할 변수
				for (int j = 0; j < d; j++) {
					if (result[j][i] == 0) { //해당 인덱스 값이 0이면
						sumA++; //연속으로 나온 A개수에 +1
						sumB = 0; //연속B가 끊겼으니까 0으로 초기화
					} else if (result[j][i] == 1) { //해당 인덱스 값이 1이면
						sumB++; //연곳으로 나온 B개수에 +1
						sumA = 0; //연속A가 끊겼으니까 0으로 초기화 
					}
					if (sumA == k || sumB == k) { //연속해서 같은 특성이 k번 나왔으면
						total++; 
						break;
					}
				}
			}
			//모든 열에서 연속해서 같은 특성이 k번 반복되고 ans보다 용액사용수가 적으면
			if (total == w && ans > cnt) { 
				ans = cnt; //ans변경
			}
			return; //리턴
		}
		//인덱스가 d보다 작을땐
		//용액 안쓴 행 결과배열에 넣기
		for (int i = 0; i < w; i++) {
			result[idx][i] = film[idx][i];
		}
		test(idx + 1); //다음 행 탐색
		
		//현재 가장 작은 용액사용 수 보다 더 작을경우에만 실행
		if (ans > cnt + 1) {
			//idx행에 A약품 투여
			for (int i = 0; i < w; i++) {
				result[idx][i] = 0;
			}
			cnt++; //약품 사용 수 +1
			test(idx + 1); //다음행 탐색
			cnt--; //돌아와서 -1로 사용수 초기화
		}
		//현재 가장 작은 용액사용 수 보다 더 작을경우에만 실행
		if (ans > cnt + 1) {
			//idx행에 B약품 투여
			for (int i = 0; i < w; i++) {
				result[idx][i] = 1;
			}
			cnt++; //약품 사용 수+1
			test(idx + 1); //다음 행 탐색
			cnt--; //돌아와서 -1로 사용수 초기화
		}
	}

}

