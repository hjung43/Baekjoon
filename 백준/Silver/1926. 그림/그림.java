import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cnt, pSize, mSize;
	static int[][] picture;
	static boolean[][] visited;
	// 델타 (상,우,하,좌)
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		picture = new int[n][m];
		visited = new boolean[n][m];
		cnt = 0; // 그림개수
		mSize = 0; // 가장 큰 그림 크기
		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				picture[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (picture[i][j] == 1 && !visited[i][j]) {
					cnt++;
					pSize = 1;
					dfs(i, j);
					mSize = Math.max(pSize, mSize);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(mSize);


	}

	public static void dfs(int pr, int pc) {
		visited[pr][pc] = true;
		for (int i = 0; i < 4; i++) {
			int nr = pr + dr[i];
			int nc = pc + dc[i];

			if (nr >= 0 && nr < n && nc >= 0 && nc < m && picture[nr][nc] == 1 && !visited[nr][nc]) {
				pSize++;
				dfs(nr, nc);
			}

		}
	}

}