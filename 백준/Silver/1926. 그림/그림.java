import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int n,m,cnt,max,size;
	static int[][] paint;
	static boolean[][] visited;
	
	//좌,상,우,하
	static int[]dr = {0,-1,0,1};
	static int[]dc = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); //도화지 세로크기
		m = Integer.parseInt(st.nextToken()); //도화지 가로크기
		
		paint = new int[n][m]; //그림배열
		visited = new boolean[n][m]; //방문배열
		
		//그림 입력받기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				paint[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cnt = 0; //그림개수
		max = 0; //가장 큰 그림의 크기
		
		//그림 찾기
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(paint[i][j]==1 && !visited[i][j]) {
					cnt++;
					size = 0;
					dfs(i,j);
					max = Math.max(max, size);
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}
	
	
	
	
	//dfs
	static void dfs(int r, int c) {
		visited[r][c] = true; //방문처리
		size++;
		
		//인접노드 찾기
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			//다음칸이 도화지 안이고 그림이있으며 방문하지 않았을 때
			if(nr>=0 && nr<n && nc>=0 && nc<m && paint[nr][nc]==1 && !visited[nr][nc]) {
				dfs(nr,nc);
			}
		}
	}
}