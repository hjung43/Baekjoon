import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m,ans;
	static int[][] mount;
	static boolean[][] visited;
	static boolean top;
	
	//좌,상,우,하
	static int[]dr = {0,-1,-1,-1,0,1,1,1};
	static int[]dc = {-1,-1,0,1,1,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken()); 
		
		mount = new int[n][m]; //산배열
		visited = new boolean[n][m]; //방문배열
		
		//산 입력받기
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				mount[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0; //총 봉우리 개수 저장할 변수
		
		//봉우리 찾기
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				//방문안한 산
				if(!visited[i][j]) {
					top = true; //우선 여기가 봉우리라고 가정하기
					bfs(i,j); //주변탐색
					//봉우리가 맞으면
					if(top) {
						ans++;
					}
				}
			}
		}
		System.out.println(ans); //총 봉우리 개수 출력
	}
	
	
	
	
	//bfs
	static void bfs(int r, int c) {
		Queue<int[]>q = new LinkedList<>(); //bfs를 위한 큐
		visited[r][c]=true; //방문체크
		q.add(new int[] {r,c}); //시작점 큐에 저장
		int h = mount[r][c]; //시작점 높이

		
		while(!q.isEmpty()) {
			int[] t = q.poll(); //현재 위치
			
			//8방탐색
			for(int i=0; i<8; i++) {
				//새 위치 좌표
				int nr = t[0]+dr[i];
				int nc = t[1]+dc[i];
				//산 안에 위치해 있으고
				if(nr>=0 && nr<n && nc>=0 && nc<m) {
					//현재 위치보다 새 위치 높이가 높으면
					if(mount[nr][nc]>h) {
						top = false; //봉우리 아님 표시
					}else if(mount[nr][nc]==h && !visited[nr][nc]) { //높이가 같고 방문 안했다면
						visited[nr][nc]=true; //방문처리
						q.add(new int[] {nr,nc}); //큐에 표시
					}
				}
				
			}
		}
	}
}