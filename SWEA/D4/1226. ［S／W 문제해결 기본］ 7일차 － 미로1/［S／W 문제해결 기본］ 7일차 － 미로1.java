import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static int result;
	static int[][]maze;
	static boolean[][] visited;
	static int[]dr = {-1,0,1,0};
	static int[]dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t=1; t<=10; t++) {
			int T = Integer.parseInt(br.readLine());
			result = 0;
			maze = new int[16][16];
			visited = new boolean[16][16];
			for(int i=0; i<16; i++) {
				String str = br.readLine();
				for (int j = 0; j < 16; j++) {
					maze[i][j] = str.charAt(j)-'0';
				}
			}
			dfs(1,1);
			System.out.println("#"+T+" "+result);
			
			
			
		}
	}
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(maze[nr][nc]==3) {
				result = 1;
				return;
			}
			if(maze[nr][nc]==0 && !visited[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}

}
