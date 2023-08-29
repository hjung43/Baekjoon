import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			char[][] map = new char[h][w];
			int si = 0;
			int sj = 0;

			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };

			int d = 0;
			for (int i = 0; i < h; i++) {
				String str = sc.next();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '<') {
						si = i;
						sj = j;
						d = 2;
					} else if (map[i][j] == '>') {
						si = i;
						sj = j;
						d = 3;
					} else if (map[i][j] == 'v') {
						si = i;
						sj = j;
						d = 1;
					} else if (map[i][j] == '^') {
						si = i;
						sj = j;
						d = 0;
					}
				}
			}
			int n = sc.nextInt();
			String dir = sc.next();

			for (int i = 0; i < n; i++) {
				if (dir.charAt(i) == 'U') {
					d = 0;
					if (si + dr[d] >= 0 && si + dr[d] < h && sj + dc[d] >= 0 && sj + dc[d] < w
							&& map[si + dr[d]][sj + dc[d]] == '.') {
						map[si][sj] = '.';
						si += dr[d];
						sj += dc[d];
					}
					map[si][sj] = '^';

				} else if (dir.charAt(i) == 'D') {
					d = 1;
					if (si + dr[d] >= 0 && si + dr[d] < h && sj + dc[d] >= 0 && sj + dc[d] < w
							&& map[si + dr[d]][sj + dc[d]] == '.') {
						map[si][sj] = '.';
						si += dr[d];
						sj += dc[d];
					}
					map[si][sj] = 'v';
				} else if (dir.charAt(i) == 'L') {
					d = 2;
					if (si + dr[d] >= 0 && si + dr[d] < h && sj + dc[d] >= 0 && sj + dc[d] < w
							&& map[si + dr[d]][sj + dc[d]] == '.') {
						map[si][sj] = '.';
						si += dr[d];
						sj += dc[d];
					}
					map[si][sj] = '<';
				} else if (dir.charAt(i) == 'R') {
					d = 3;
					if (si + dr[d] >= 0 && si + dr[d] < h && sj + dc[d] >= 0 && sj + dc[d] < w
							&& map[si + dr[d]][sj + dc[d]] == '.') {
						map[si][sj] = '.';
						si += dr[d];
						sj += dc[d];
					}
					map[si][sj] = '>';
				} else if (dir.charAt(i) == 'S') {
					int bi = si;
					int bj = sj;
					while (bi + dr[d] < h && bi + dr[d] >= 0 && bj + dc[d] < w && bj + dc[d] >= 0
							&& map[bi][bj] != '#') {
						bi += dr[d];
						bj += dc[d];
						if (map[bi][bj] == '*') {
							map[bi][bj] = '.';
							break;
						}
					}
				}

			}
			System.out.print("#" + t + " ");
			for (int l = 0; l < h; l++) {
				for (int j = 0; j < w; j++) {
					System.out.print(map[l][j]);
				}
				System.out.println();
			}
		}
	}

}