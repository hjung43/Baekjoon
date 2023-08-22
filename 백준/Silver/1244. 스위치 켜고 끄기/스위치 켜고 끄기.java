import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //스위치 개수
		int[] s = new int[n]; //스위치 정보 담을 배열
		//스위치 정보 담기
		for(int i=0; i<n; i++) {
			s[i] = sc.nextInt();
		}
		int student = sc.nextInt(); //학생 수 입력
		//학생수 만큼 반복하기
		for(int i=0; i<student; i++) {
			int g = sc.nextInt(); //학생성별 입력
			int num = sc.nextInt(); //학생이 받은 수 입력
			if(g==1) { //성별이 남자면
				//스위치 배열 탐색
				for(int j =1; j<=n; j++) {  //j는 스위치 번호
					//현재 스위치 번호가 학생이 받은 수의 배수이고 스위치가 켜져있다면(인덱스라 -1)
					if(j%num==0 && s[j-1]==1) { 
						s[j-1] = 0; //스위치 끄기
					}else if(j%num==0 && s[j-1]==0) //현재 스위치가 학생이 받은수의 배수고 스위치가 꺼져있다면
						s[j-1]=1; //스위치 켜기
				} 
			}else{   //성별이 여자면
				int j = num-1;  //학생이 받은 수 인덱스 값으로 변경
				if(s[j]==0) {  //학생이 받은수의 스위치가 꺼져있으면
					s[j] =1;  //켜기
				}else if(s[j]==1)  //켜져있으면
					s[j] = 0; //끄기
				int k = 1;  //스위치 이동을 위한 변수(j를 기준으로 양옆으로 펴지게)
				
				//j를 기준으로 양옆의 값이 인덱스 내에 있고 값이 같을때
				while(j+k<n && j-k>=0 && s[j+k]==s[j-k]) {
					if(s[j+k]==0) { //둘다 불이 꺼져있으면
						s[j+k] = s[j-k] = 1; //켜기
					}else //켜져있으면
						s[j+k] = s[j-k] = 0; //끄기
					k++; //한칸씩 더 이동
				}
			}
		}
		//한줄에 20개씩 출력하기
		for(int i=0; i<n; i++) {
			if(i%20==0 && i!=0) {
				System.out.println();
				System.out.print(s[i]+" ");
			}else
				System.out.print(s[i]+" ");
		}
	}
}