import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 수 입력
		// 테스트 케이스 만큼 반복
		for (int t = 1; t <= T; t++) {
			String str = sc.next(); //카드정보 한줄로 입력받기 
			StringTokenizer st = new StringTokenizer(str, "SDHC", true); //S,D,H,C를 기준으로 문자열 나누기(S,D,H,C도 토큰으로 저장)
			int[][] arr = new int[4][13 + 1]; //카드가 겹치는지 확인할 배열 생성
			int S = 13, D = 13, H = 13, C = 13; //S,D,H,C 각각의 카드 개수 저장
			boolean ne = true; //카드의 숫자가 안겹치면  true, 겹치면 false 
			//다음 토큰이 있을때만 반복
			while (st.hasMoreTokens()) {
				String card = st.nextToken(); //카드 무늬 토큰 가져오기
				int xy = Integer.parseInt(st.nextToken()); //카드 숫자 가져오기
				if (card.equals("S")) { //카드가 스페이스라면
					arr[0][xy]++; //0번행의 해당숫자 인덱스+1
					if (arr[0][xy] > 1) { //해당 인덱스가 2 이상이면 (같은 카드가 있으면)
						ne = false; //결과값 바꾸기
						break; 
					}else //아니면
						S--; //스페이스 카드 수 줄이기
				} else if (card.equals("D")) { //카드가 다이아라면
					arr[1][xy]++;   //1번행의 해당숫자 인덱스+1
					if (arr[1][xy] > 1) { //해당 인덱스가 2 이상이면 (같은 카드가 있으면)
						ne = false; //결과값 바꾸기
						break;
					}else //아니면
						D--; //다이아 카드 수 줄이기
				} else if (card.equals("H")) { //카드가 하트라면
					arr[2][xy]++; //2번행의 해당숫자 인덱스+1
					if (arr[2][xy] > 1) { //해당 인덱스가 2 이상이면 (같은 카드가 있으면)
						ne = false; //결과값 바꾸기
						break; 
					}else //아니면
						H--; //하트 카드 수 줄이기
				} else { //카드가 클로버라면
					arr[3][xy]++; //3번행의 해당숫자 인덱스+1
					if (arr[3][xy] > 1) { //해당 인덱스가 2 이상이면 (같은 카드가 있으면)
						ne = false; //결과값 바꾸기
						break;
					}else //아니면
						C--; //클로버 카드 수 줄이기
				}
			}
			//결과값이 true라면
			if(ne) {
				System.out.printf("#%d %d %d %d %d\n",t,S,D,H,C); //부족한카드수 출력
			}else //아니면
				System.out.println("#" + t + " " + "ERROR"); //ERROR출력

		}
	}
}