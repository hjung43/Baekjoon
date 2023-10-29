import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] ice;
	static int[][] nice;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<int[]> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ice = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		int result = 0;
		while (cnt == 1) {
//			System.out.println("엥");
			cnt = 0;
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (ice[i][j] != 0 && !visited[i][j]) {
//						System.out.println("엥2");
						bfs(i, j);
						cnt++;
					}
				}
			}
			if (cnt == 0) {
				result = 0;
				break;
			} else if (cnt > 1) {
				break;
			} else {
				melting();
				result++;
			}
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(ice[i][j]);
//				}System.out.println();
//			}
		}
		System.out.println(result);
	}

	static void melting() {
		nice = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (ice[i][j] != 0) {
					int w = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr >= 0 && nr < n && nc >= 0 && nc < m && ice[nr][nc] == 0) {
							w++;
						}
					}
					if (ice[i][j] - w < 0) {
						nice[i][j] = 0;
					} else {
						nice[i][j] = ice[i][j]-w;
					}
				}
			}
		}
		for(int i=0; i<n; i++) {
			ice[i] = nice[i].clone();
			Arrays.fill(nice[i], 0);
		}
	}

	static void bfs(int r, int c) {
//		System.out.println("엥3");
		q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = tmp[0] + dr[i];
				int nc = tmp[1] + dc[i];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && ice[nr][nc] != 0 && !visited[nr][nc]) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}
	}
}