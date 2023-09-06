import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수 입력
		// 테스트 케이스 만큼 반복
		for (int t = 1; t <= T; t++) {
			String move = sc.next();
			//상 우 하 좌 (오른쪽으로 돌때)
			int[] dr = {-1,0,1,0};
			int[] dc = {0,1,0,-1};
			int d = 500; //방향값을 위한 변수(L만 500번 나올수 도 있으니까 /L일때는 인덱스를 1씩 줄여야함)
			int sR = 0; //거북이의 출발지점R
			int sC = 0; //거북이의 출발지점C
			//시작지점이 0,0이므로 모든 최대 최소값 0으로 초기화
			int minR = 0;
			int maxR = 0;
			int minC = 0;
			int maxC = 0;
			//거북이 이동
			for(int i=0; i<move.length(); i++) {
				if(move.charAt(i)=='F') { //F일때
					sR += dr[d%4]; //현재 지점에 dr[d%4]만큼 더하기
					sC += dc[d%4]; //현재 지점에 dc[d%4]만큼 더하기
					if(minR>sR) minR = sR;
					if(minC>sC) minC = sC;
					if(maxR<sR) maxR = sR;
					if(maxC<sC) maxC = sC;
				}else if(move.charAt(i)=='B') { //B일때
					sR -= dr[d%4]; //현재 지점에 dr[d%4]만큼 빼기
					sC -= dc[d%4]; //현재 지점에 dc[d%4]만큼 빼기
					if(minR>sR) minR = sR;
					if(minC>sC) minC = sC;
					if(maxR<sR) maxR = sR;
					if(maxC<sC) maxC = sC;
				}else if(move.charAt(i)=='L') { //L일때
					d--; //d-1해서 왼쪽 90도로 방향전환
				}else //R일때
					d++; //d+1해서 오른쪽 90도로 방향전환
			}
			//결과값 출력
			System.out.println((maxR-minR)*(maxC-minC));
		}
	}
}