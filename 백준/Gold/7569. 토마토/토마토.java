import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] box;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		box = new int[h][n][m]; //토마토 담을 3차원 배열 만들기
		Queue<int[]> q = new LinkedList<>(); //BFS에 사용할 큐 만들기
		boolean[][][] visited = new boolean[h][n][m]; //상자 방문배열
		//델타
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int[] dh = { -1, 1 }; //상자 높이는 위아래로만 이동
		int end = 0; //안익은 토마토 개수 세는 변수
		
		//토마토 상자배열에 넣기
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken()); //상자에 토마토 넣기
					//안익은 토마토수 세기
					if (box[i][j][k] == 0) {
						end++;
					}
					//익은 토마토 큐에 넣기
					if (box[i][j][k] == 1) {
						q.add(new int[] { i, j, k, 0 }); //높이, 세로, 가로, 날짜
						visited[i][j][k] = true; //방문처리
					}
				}
			}
		}
		//이미 토마토가 다 익었다면
		if (end == 0) {
			System.out.println(0);
			return;
		}
		int ans = 0; //최소일수 저장할 변수
		// BFS
		while (!q.isEmpty()) { //큐가 빌때까지 반복
			int[] t = q.poll(); //큐의 제일 첫번째 원소 꺼내기
			//델다사용 -> 상,우,하,좌
			for (int i = 0; i < 4; i++) {
				int nr = t[1] + dr[i];
				int nc = t[2] + dc[i];
				//새로운 위치가 인덱스를 벗어나지 않고 방문하지 않았으며 토마토가 아직 안익었다면
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[t[0]][nr][nc] && box[t[0]][nr][nc] == 0) {
					int[] nt = { t[0], nr, nc, t[3] + 1 }; //새로운 위치 배열(일수는 현재위치날짜 +1해서)
					q.add(nt); //새로운 위치 큐에 저장
					end--; //안익은 토마토수 -1
					box[t[0]][nr][nc] = 1; //익은 토마토로 바꿔주기
					visited[t[0]][nr][nc] = true; //방문처리
					ans = Math.max(ans, t[3] + 1); //ans의 값보다 새로운 위치의 토마토가 익는 날짜가 더 크면 바꾸기
				}
			}
			//위아래(높이) 탐색
			for (int i = 0; i < 2; i++) {
				int nh = t[0] + dh[i]; //높이 델타를 이용해 새로운 위치
				//새로운 위치가 인덱스를 벗어나지 않고 방문하지 않았으며 토마토가 아직 안익었다면
				if (nh >= 0 && nh < h && !visited[nh][t[1]][t[2]] && box[nh][t[1]][t[2]] == 0) {
					int[] nt = { nh, t[1], t[2], t[3] + 1 };  //새로운 위치 배열(새로운 높이, 현재 가로세로, 일수는 현재위치날짜 +1해서)
					q.add(nt); //큐에 새로운 위치 저장
					end--; //안익은 토마토 수 -1
					box[nh][t[1]][t[2]] = 1; //익은 토마토로 바꿔주기
					visited[nh][t[1]][t[2]] = true; //방문처리
					ans = Math.max(ans, t[3] + 1); //ans보다 새로운 위치의 토마토가 익는 날짜가 거 크면 바꿔주기
				}
			}

		}
		//만약 토마토가 다 익지 않았다면
		if (end != 0) {
			System.out.println(-1); //-1출력
		} else { //다 익었으면
			System.out.println(ans); //최소일수 출력
		}
	}
}