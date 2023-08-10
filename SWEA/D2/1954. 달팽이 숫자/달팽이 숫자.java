import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수
		int[] dr = { 0, 1, 0, -1 };
		int[] dc = { 1, 0, -1, 0 };

		// 테스트 케이스만큼 반복
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt(); // 판 크기 받기
			int[][] snail = new int[n][n];
			int num = 1;
			int r = 0;
			int c = -1;
			for (int i = 0; i < n * 2 - 1; i++) {
				for (int j = 0; j < n; j++) {
					if (r + dr[i % 4] >= 0 && c + dc[i % 4] >= 0 && r + dr[i % 4] < n && c + dc[i % 4] < n && snail[r+ dr[i % 4]][c+ dc[i % 4]] == 0) {
						r += dr[i % 4];
						c += dc[i % 4];
						if (snail[r][c] == 0) {
							snail[r][c] = num++;
						}
					}else {
						continue;
					}
				}
			}
			System.out.println("#"+t);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
}