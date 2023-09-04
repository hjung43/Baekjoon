import java.util.Scanner;

public class Solution {
	static int n; //고객수
	static int[][] sted; //집과 회사의 좌표 저장할 배열
	static int[][] cus; //고객 집의 좌표 저장할 배열
	static boolean[]visit; //해당 집 방문 유무
	static int[][]result; //각 순열집합 저장할 배열
	static int ans; //결과값 저장할 변수(회사에서 출발해 모든 고객의 집을 방문하고 집으로 돌아오는 가장 짧은 경로)

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 케이스 입력
		//테스트 케이스 만큼 반복
		for(int t=1; t<=T; t++) { 
			n = sc.nextInt(); //고객수 입력
			sted = new int[2][2]; //집과 회사의 좌표 테케 실행할때마다 초기화
			cus = new int[n][2]; //고객 집 좌표 저장할 배열 크기 선언
			visit = new boolean[n]; //집 방문 유무 배열 크기 선언(고객수 만큼)
			result = new int [n][2]; //순열집합 크기 선언
			ans = Integer.MAX_VALUE; //결과값 저장할 변수 초기화
			for(int i = 0; i<2; i++) {
				sted[i][0] = sc.nextInt(); //집과 회사의 x값
				sted[i][1] = sc.nextInt(); //집과 회사의 y값
			}
			for(int i=0; i<n; i++) {
				cus[i][0] = sc.nextInt(); //고객의 집 x값
				cus[i][1] = sc.nextInt(); //고객의 집 y값
			}
			perm(0); //함수실행
			System.out.println("#"+t+" "+ans); //답 출력
		}
		

	}
	//최단거리 구하는 함수
	public static void  perm(int idx) {
		if(idx==n) { //result의 인덱스가 n이 되면
			//전체 거리합을 회사에서 result의 제일 첫집까지의 거리로 초기화
			int sum = Math.abs(sted[0][0]-result[0][0])+Math.abs(sted[0][1]-result[0][1]);
			//반복문 돌면서 전체 거리합에 각 집과 집사이의 거리 더하기
			for(int i=1; i<n; i++) {
				sum += Math.abs(result[i-1][0]-result[i][0])+Math.abs(result[i-1][1]-result[i][1]);
			}
			//고객의 집과집사이 거리 더한 후 마지막 고객집과 김대리의 집까지의 거리 더하기
			 sum += Math.abs(sted[1][0]-result[n-1][0])+Math.abs(sted[1][1]-result[n-1][1]);
			 if(sum<ans) { //만약 전체 거리합이 ans보다 작으면
				 ans = sum; //ans변경
			 }
			 return; //리턴하기
		}
		//모든 순열 탐색
		for(int i=0; i<n; i++) {
			if(!visit[i]) { //visit[i]가 false면
				result[idx][0] = cus[i][0]; //result에 인덱스i번째 고객의 집 위치 저장
				result[idx][1] = cus[i][1];
				visit[i] = true; //방문했으니까 true로 변경
				perm(idx+1); //다음 인덱스 실행
				visit[i] = false; //돌아와서 false로 초기화
			}
		}
	}

}