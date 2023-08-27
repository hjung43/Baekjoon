import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		char[][] map = new char[r + 2][c + 2];
		char[][] nMap = new char[r + 2][c + 2];
		for (int i = 0; i < r + 2; i++) {
			for (int j = 0; j < c + 2; j++) {
				map[i][j] = '.';
			}
		}

		for (int i = 1; i <= r; i++) {
			String str = sc.next();
			for (int j = 1; j <= c; j++) {
				map[i][j] = str.charAt(j - 1);
			}
		}
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				int cnt = 0;
				if (map[i][j] == 'X') {
					for (int k = 0; k < 4; k++) {
						if (map[i + dr[k]][j + dc[k]] == '.') {
							cnt++;
						}
					}
					if (cnt > 2) {
						nMap[i][j] = '.';
					} else {
						nMap[i][j] = 'X';
					}
				} else {
					nMap[i][j] = '.';
				}

			}
		}
		int mini = Integer.MAX_VALUE;
		int minj = Integer.MAX_VALUE;
		int maxi = Integer.MIN_VALUE;
		int maxj = Integer.MIN_VALUE;
		for(int i=1; i<=r; i++) {
			for(int j=1; j<=c; j++) {
				if(nMap[i][j]=='X') {
					if(mini>i) mini = i;
					if(maxi<i) maxi = i;
					if(minj>j) minj = j;
					if(maxj<j) maxj = j;
				}
			}
		}
		for(int i=mini; i<=maxi; i++) {
			for(int j=minj; j<=maxj; j++) {
				System.out.print(nMap[i][j]);
			}
			System.out.println();
		}
	}
}