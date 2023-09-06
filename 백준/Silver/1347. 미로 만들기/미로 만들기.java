import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 문자열 길이 입력

		char[][] map = new char[101][101]; // 명령길이가 최대 50이니까 두배인 100+1로 인덱스 설정
		//배열 전체 #으로 채우기
		for (int i = 0; i < 101; i++) {
			Arrays.fill(map[i], '#');
		}
		String move = sc.next(); //문자열 입력
		// 하 좌 상 우 (시작은 남쪽을 보고 오른쪽으로 돌때)
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, -1, 0, 1 };
		map[50][50] = '.'; // 배열의 한 가운데부터 시작(시작지점도 .으로 만들어 주기)
		int d = 100; // 방향값을 위한 변수(L만 50번 나올수 도 있으니까 50이상 4로 나누어 떨어지는 수 /L일때는 인덱스를 1씩 줄여야함)
		int sR = 50; // 미로의 출발지점R
		int sC = 50; // 미로의 출발지점C
		// 미로 이동
		for (int i = 0; i < n; i++) {
			if (move.charAt(i) == 'F') { // F일때
				sR += dr[d % 4]; // 현재 지점에 dr[d%4]만큼 더하기
				sC += dc[d % 4]; // 현재 지점에 dc[d%4]만큼 더하기
				map[sR][sC] = '.';
			} else if (move.charAt(i) == 'L') { // L일때
				d--; // d-1해서 왼쪽 90도로 방향전환
			} else // R일때
				d++; // d+1해서 오른쪽 90도로 방향전환
		}
		// 인덱스 값이 1인 인덱스들 중 가장 작은 행값과 열값 찾기
		int mini = Integer.MAX_VALUE;
		int maxi = Integer.MIN_VALUE;
		int minj = Integer.MAX_VALUE;
		int maxj = Integer.MIN_VALUE;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if (map[i][j] == '.') {
					if (mini > i)
						mini = i;
					if (minj > j)
						minj = j;
					if (maxi < i)
						maxi = i;
					if (maxj < j)
						maxj = j;
				}
			}
		}
		// 결과값 출력
		for (int i = mini; i <= maxi; i++) {
			for (int j = minj; j <= maxj; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}