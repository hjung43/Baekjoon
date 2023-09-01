import java.util.Scanner;

public class Solution {
	public static int N; //체스판의 크기, 퀸의 개수
	public static int[][] result; //체스판 배열
	public static int[] dc = { -1, 0, 1 }; //델타이용해서 퀸 위치 찾기(좌상, 상, 우상)
	public static int count; //총 체스판에 놓아진 퀸의 개수 확인할 변수
	public static int ans; //체스판에 N개의 체스를 놓은 경우의 수를 저장할 변수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 케이스 입력
		//테스트 케이스 만큼 반복
		for (int t = 1; t <= T; t++) {
			count = 0; //테스트 케이스마다 퀸의 개수 초기화
			ans = 0; //테스트 케이스마다 답0으로 초기화
			N = sc.nextInt(); //체스판의 크기, 퀸의 개수 입력 받기
			result = new int[N][N]; //체스판 만들기
			perm(0); //함수 불러오기(괄호안의 숫자는 체스판의 행!! -> 인덱스0의 행부터 시작)
			System.out.println("#" + t + " " + ans); //답 출력하기 (체스판에 N개의 체스를 놓은 경우의수 출력)
		}
	}

	//i = 체스판 탐색할 행의 위치
	public static void perm(int i) {
		if (count == N) { //체스판 위에 체스(count)가 N개이면
			ans++; //체스판에 N개의 체스를 놓은 경우의 수++
			return; //리턴
		}
		if (i >= N) { //i가 체스판 행의 크기를 벗어나면
			return; //리턴하기
		}
		//체스판 열탐색
		for (int j = 0; j < N; j++) { //j는 체스판의 열의 위치
			int cnt = 0; //탐색한 위치에 체스가 있는지 확인할 변수
			for (int d = 0; d < 3; d++) { //델타를 이용하기 위한 변수 (3방향 탐색)
				//i,j값을 바꿔가며 탐색하기 때문에  r,c에 저장해서 탐색하기
				int r = i;
				int c = j;
				while (r - 1 >= 0 && c + dc[d] >= 0 && c + dc[d] < N) { //r-1과 c+dc[d]가 인덱스 밖을 벗어나지 않는다면
					//현재 위치에서 좌상, 상, 우상 탐색
					r--; //r-1(행은 항상 자신의 위쪽행만 탐색)
					c += dc[d];
					if (result[r][c] == 1) { //현재 위치에서 좌상, 상, 우상에 체스가 있으면
						cnt++; //체스수 +1
						break; //while문 중단
					}
				}

			}
			if (cnt == 0) { //현재 위치에서 좌상, 상, 우상으로 체스가 없으면
				result[i][j] = 1; //현재 위치에 체스 놓기(놓으면 1, 없으면 0)
				count++; //체스판 위의 체스 수 +1
				perm(i + 1); //다음 행 체스 위치 확인하기
				result[i][j] = 0; //다음 열 체스 탐색 위해 체스 수거
				count--; //체스 개수 -1
			}

		}

	}

}