import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
				//도화지에 그림이 있고, 방문하지 않았다면
				if(paint[i][j]==1 && !visited[i][j]) {
					cnt++; //그림개수 세기
					size = 0; //그림크기 0으로 초기화
					dfs(i,j); //dfs호출
					max = Math.max(max, size); //size가 max보다 더 크면 max값 size값으로 초기화
				}
			}
		}
		System.out.println(cnt); //총 그림개수 출력
		System.out.println(max); //가장 큰 그림 크기 출력
	}
	
	
	
	
	//dfs
	static void dfs(int r, int c) {
		visited[r][c] = true; //방문처리
		size++; //그림 크기 추가
		
		//그림 크기 탐색
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