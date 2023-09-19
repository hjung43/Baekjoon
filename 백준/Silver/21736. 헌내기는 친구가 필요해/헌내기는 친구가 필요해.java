import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cnt;
	static char[][] uni;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		uni = new char[n][m];
		visited = new boolean[n][m];
		cnt = 0;
		int doR = 0;
		int doC = 0;

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				uni[i][j] = str.charAt(j);
				if (uni[i][j] == 'I') {
					doR = i;
					doC = j;
				}
			}
		}
		dfs(doR, doC);
		if (cnt == 0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}
	}

	public static void dfs(int doR, int doC) {
		visited[doR][doC] = true;
		for (int i = 0; i < 4; i++) {
			int nr = doR + dr[i];
			int nc = doC + dc[i];
			if (nr >= 0 && nr < n && nc >= 0 && nc < m && uni[nr][nc] != 'X' && !visited[nr][nc]) {
				if (uni[nr][nc] == 'P') {
					cnt++;
				}
				dfs(nr, nc);
			}
		}
	}

}