import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트 케이스 수 받기
		//테스트 케이스 수 만큼 반복
		for(int t=1; t<=T; t++) {
			int n =sc.nextInt(); //정렬할 수 개수 입력
			int[]arr = new int [n]; //정렬한 수 크기 만큼 배열 만들기
			//배열에 정렬할 수 넣기
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			//배열 삽입정렬로 정렬하기
			for(int i=1; i<n; i++) { //0번 인덱스는 이미 정렬되어 있으므로 1번부터
				int key = arr[i]; //현재 정렬할 수 저장
				int j; //for문 밖에서 j사용하기 위해 선언
				//i-1부터 0번 인덱스 까지 key가  arr[j]보다 작을때만 반복
				for(j = i-1; j>=0 && arr[j]>key; j--) {
					arr[j+1] = arr[j]; //j+1에 j값넣기
				}
				arr[j+1] = key; //key가 더 작지 않을때 j+1에 key값 넣기 
			}
			//결과값 출력하기
			System.out.print("#"+t+" ");
			for(int i : arr) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}