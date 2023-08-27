import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt(); //방 세로크기
		int c = sc.nextInt(); //방 가로크기
		int[][]room = new int[r][c];
		int k = sc.nextInt(); //장애물의 개수
		for(int i=0; i<k; i++) {
			int bR = sc.nextInt(); //장애물 세로위치
			int bC = sc.nextInt(); //장애물 가로위치
			room[bR][bC] = 1;
		}
		int sR = sc.nextInt(); //로봇 세로위치
		int sC = sc.nextInt(); //로봇 가로위치
		room[sR][sC] = 1;
		int[] dR = new int [4];
		int[] dC = new int [4];
		for(int i=0; i<4; i++) {
			int d = sc.nextInt();
			if(d==1) {
				dR[i] = -1;
			}else if(d==2)
				dR[i] = 1;
			else if(d==3)
				dC[i] = -1;
			else
				dC[i] = 1;
		}
		int i = 0;
		int end = 0;
		while (true) {
			if(sR+dR[i%4]>=0 && sR+dR[i%4]<r && sC+dC[i%4]>=0 && sC+dC[i%4]<c && room[sR+dR[i%4]][sC+dC[i%4]]==0) {
				sR += dR[i%4];
				sC += dC[i%4];
				room[sR][sC] = 1;
				end = 0;
			}else {
				i++;	
				end++;
			}
			if(end==4) {
				break;
			}
		}
		System.out.println(sR+" "+sC);
	}
}