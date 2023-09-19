import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int result; // 도착점에 갈 수 있는지 결과를 저장할 변수
	static int[][] maze; // 미로받을 배열
	static boolean[][] visited; // 미로에 길을 방문했는지 확인할 배열
	// 델타 (상,우,하,좌)
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine()); // 테스트케이스번호 입력
			result = 0; // 0(도착점 도착 불가능)으로 초기화
			maze = new int[16][16]; // 배열 선언
			visited = new boolean[16][16];
			// 배열 입력받기
			for (int i = 0; i < 16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					maze[i][j] = str.charAt(j) - '0';
				}
			}
			dfs(1, 1); // dfs로 도착점 갈수 있는지 확인(시작점은 항상 1,1)
			System.out.println("#" + T + " " + result); // 결과 출력
		}
	}

	// dfs함수
	public static void dfs(int r, int c) {
		visited[r][c] = true; // 방문표시

		// 델타배열 순으로 사방탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			// 다음 위치에 도착점이 있다면 결과값 바꾸고 리턴
			if (maze[nr][nc] == 3) {
				result = 1;
				return;
			}
			// 다음위치가 길(0)이고 방문하지 않은 곳이라면
			if (maze[nr][nc] == 0 && !visited[nr][nc]) {
				dfs(nr, nc); // 재귀호출(그 위치부터 또 사방탐색)
			}
		}
	}

}
