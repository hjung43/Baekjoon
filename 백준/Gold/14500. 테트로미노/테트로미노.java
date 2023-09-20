import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, sum, result, size;
	static int[][] tm;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		tm = new int[n][m];
		visited = new boolean[n][m];
		result = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				tm[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				sum = tm[i][j];
				size = 1;
				dfs(i, j);
				visited[i][j] = false;
				t(i, j);

			}
		}
		System.out.println(result);
	}

	public static void dfs(int r, int c) {

		if (size == 4) {
			result = Math.max(sum, result);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
				size++;
				sum += tm[nr][nc];
				visited[nr][nc] = true;
				dfs(nr, nc);
				visited[nr][nc] = false;
				size--;
				sum -= tm[nr][nc];
			}
		}
	}

	public static void t(int r, int c) {
		loop: for (int i = 0; i < 4; i++) {
			size = 0;
			sum = tm[r][c];
			for (int j = i; j < i + 3; j++) {
				int nr = r + dr[j % 4];
				int nc = c + dc[j % 4];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
					size++;
					sum += tm[nr][nc];
				} else {
					continue loop;
				}
			}
			result = Math.max(sum, result);

		}
	}
}