import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int n, r, g, b, rg, bb;
	static char[][] picture;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		picture = new char[n][n];
		visited1 = new boolean[n][n];
		visited2 = new boolean[n][n];
		r = g = b = rg = bb = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				picture[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited1[i][j]) {
					if (picture[i][j] == 'R') {
						r++;
					} else if (picture[i][j] == 'B') {
						b++;
					} else {
						g++;
					}
					dfs1(i, j);
				}
				if (!visited2[i][j]) {
					if (picture[i][j] == 'R' || picture[i][j] == 'G') {
						rg++;
					} else if (picture[i][j] == 'B') {
						bb++;
					}
					dfs2(i, j);
				}
			}
		}
		System.out.println((r+g+b)+" "+(rg+bb));
	}

	public static void dfs1(int pr, int pc) {
		visited1[pr][pc] = true;
		char color = picture[pr][pc];

		for (int i = 0; i < 4; i++) {
			int nr = pr + dr[i];
			int nc = pc + dc[i];
			if (nr >= 0 && nr < n && nc >= 0 && nc < n && picture[nr][nc] == color && !visited1[nr][nc]) {
				dfs1(nr, nc);
			}

		}
	}

	public static void dfs2(int pr, int pc) {
		visited2[pr][pc] = true;
		char color = picture[pr][pc];

		for (int i = 0; i < 4; i++) {
			int nr = pr + dr[i];
			int nc = pc + dc[i];
			if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited2[nr][nc]) {
				if (color == 'R' && (picture[nr][nc] == 'R' || picture[nr][nc] == 'G'))
					dfs2(nr, nc);
				else if(color == 'G' && (picture[nr][nc] == 'R' || picture[nr][nc] == 'G'))
					dfs2(nr,nc);
				else if(color=='B' && picture[nr][nc] == 'B') {
					dfs2(nr,nc);
				}
			}

		}
	}

}
