import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[][]box;
	//델타 상,우,하,좌
	static int[]dr = {-1,0,1,0};
	static int[]dc = {0,1,0,-1};
	static boolean[][]visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); //상자의 가로크기
		n = Integer.parseInt(st.nextToken()); //상자의 세로크기
		
		box = new int[n][m]; //토마토 담을 상자 배열
		visited = new boolean[n][m]; //방문체크할 배열(없어도 될듯)
		Queue<int[]>q = new LinkedList<>(); //익은 토마토 담을 큐
		int end = 0; //안익은 토마토 수 셀 변수
		//상자에 토마토 담기
		for(int i=0; i<n; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				box[i][j] = Integer.parseInt(st1.nextToken());
				//안익은 토마토 수 세기
				if(box[i][j]==0) {
					end++;
				}
				//큐에 익은 토마토 넣기
				if(box[i][j] == 1) {
					q.add(new int[] {i,j,0}); //인덱스 2 = 날짜 . 아직 하루도 안지났으니까 0
					visited[i][j] = true; //방문처리 해주기
				}
			}
		}
		if(end==0) { //안익은토마토가 하나도 없으면 0출력후 리턴 (이거 안해도 밑에서 걸러져서 0으로 출력되긴한다)
			System.out.println(0);
			return;
		}
		int ans = 0; //정답(토마토가 다 익는 최소날짜)저장할 변수
		//BFS
		while(!q.isEmpty()) {  //큐가 빌때까지
			int[] t = q.poll(); //큐에 저장된 토마토 꺼내기
			//4방탐색
			for(int i=0; i<4; i++) {
				int nr = t[0]+dr[i]; 
				int nc = t[1]+dc[i];
				//인덱스를 안벗어나고 토마토가 안익었고 방문하지 않았다면
				if(nr>=0 && nr<n && nc>=0 && nc<m && box[nr][nc]==0 && !visited[nr][nc]) {
					int nt[] = {nr, nc, t[2]+1}; //익은토마토로 바꿔서 큐에저장 (날짜는 현재 꺼내진 토마토 일수+1)
					q.add(nt);
					box[nr][nc]=1; //익은 토마토로 바꾸기
					visited[nr][nc] = true; //방문처리
					ans = Math.max(ans, t[2]+1); //가장 큰 날짜 정답에 저장
				}
			}
		}
		//BFS를 다 돌았는데도 안익은 토마토가 있다면
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(box[i][j] == 0) {
					System.out.println(-1); //-1출력
					return;
				}
			}
		}
		//안익은 토마토 없으면 날짜 출력
		System.out.println(ans);
		
	}
}