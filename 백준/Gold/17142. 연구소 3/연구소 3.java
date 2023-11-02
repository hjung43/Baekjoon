import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int n, m, size, ans, zcnt;
	static int[][] map;
	static Queue<int[]> q;
	static List<int[]> list;
	static int[] sel;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //연구소 크기
		m = Integer.parseInt(st.nextToken()); //활성화할 바이러스 수
		map = new int[n][n]; //연구소 배열
		list = new ArrayList<>(); //바이러스 위치 담을 리스트
		zcnt = 0; //빈칸 개수 저장할 변수
		
		//연구소 배열 입력		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				//해당칸에 바이러스가 있으면
				if (map[i][j] == 2) {
					//리스트에 좌표(r,c),활성바이러스 생긴 시간(0) 배열로 저장
					list.add(new int[] { i, j, 0 });
				}
				//빈칸 개수 세기
				if(map[i][j]==0) {
					zcnt++;
				}
			}
		}
		//빈칸이 없으면
		if(zcnt==0) {
			//이미 바이러스가 다 있는거니까 그냥 0출력 후 종료
			System.out.println(0);
			return;
		}
		
		size = list.size(); //연구소에 있는 바이러스 개수
		sel = new int[m]; //조합배열 (조합이용해서 해당 인덱스에 있는 바이러스 좌표 꺼낼거다!!)
		ans = 0; //결과값
		comb(0, 0); //조합
		System.out.println(ans);

	}
	//조합으로 바이러스m개 고르기(그냥 0~size 숫자 중에 m개 만큼 고르기 -> 고른 숫자 해당하는 인덱스에 있는 바이러스 좌표 활성화)
	static void comb(int idx, int sidx) {
		if (sidx == m) {
			//m개 다 골랐으면 바이러스 퍼뜨리기(현재 빈칸의 개수 가지고 가가)
			bfs(zcnt);
			return;
		}
		if (idx == size) {
			return;
		}
		sel[sidx] = idx;
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}
	
	//bfs
	static void bfs(int zcnt) {
		int cnt = zcnt; //빈칸개수 저장 (자꾸 변경할거니까 static에 있는거 쓰면 안됨)
		q = new LinkedList<>(); //bfs에 사용할 큐
		visited = new boolean[n][n]; //bfs돌때마다 새로운 visited배열 생성해주기
		//큐에 선택된 바이러스 넣기
		for (int i = 0; i < m; i++) {
			int[] tmp = list.get(sel[i]).clone();
			q.add(tmp);
			visited[tmp[0]][tmp[1]] = true;
		}
		
		int time = 0; //바이러스 다 퍼뜨렸을때 시간 저장할 배열
		//bfs돌기
		loop: while (!q.isEmpty()) {
			int[] t = q.poll(); //큐에서 하나 꺼내기
			for (int i = 0; i < 4; i++) {
				int nr = t[0] + dr[i];
				int nc = t[1] + dc[i];
				int nt = t[2] + 1;
				//이동해야할 위치가 배열 안에있고 0이면
				if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] ==0 && !visited[nr][nc]) {
					visited[nr][nc] = true; //방문처리
					time = Math.max(time, nt); //시간 변경
					q.add(new int[] { nr, nc, nt }); //큐에 저장
					cnt--; //빈칸 하나 사라졌으니까 빼주기
					//빈칸이 아예 없어지면 while문 멈추기
					if(cnt==0)
						break loop;
				}
				//이동해야할 위치가 배열안에 있고 2이면
				if (nr >= 0 && nr < n && nc >= 0 && nc < n && map[nr][nc] == 2 && !visited[nr][nc]) {
					visited[nr][nc] = true; //방문처리
					time = Math.max(time, nt); //시간변경
					q.add(new int[] { nr, nc, nt }); //큐에저장
					//원래 있던 바이러스가 활성화 된거니까 빈칸 안빼준다!!!!
				} 
			}
		}
		//결과값 저장
		if(cnt==0) { //빈칸없이 다 돌았을때
			if(ans<=0) { //현재 결과값이 0보다 작거나 같으면
				ans = time; //결과값 갱신
			}else if(ans>0) { //0보다 크면
				ans = Math.min(time, ans); //더 큰 값으로 결과값 갱신
			}                
		}else { //빈칸이 있으면
			if(ans==0) { //결과값이 0일때만 
				ans = -1; //-1로 바꿔주기 (0이외는 그냥 안바꿔줘도 됨)
			}
		}
	}
}