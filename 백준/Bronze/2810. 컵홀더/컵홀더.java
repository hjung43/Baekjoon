import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();   //총 좌석수
		String str = sc.next(); //좌석 문자열로 받기
		char[]seat = new char[n]; //좌석을 담을 배열
		int cup = 0;
		int l = 0;
		//좌석 배열에 문자로 담기
		for(int i=0; i<n; i++) {
			seat[i] = str.charAt(i);
		}
		for(int i=0; i<n; i++) {
			if(seat[i]=='S') {
				cup++;
			}else if(seat[i]=='L') {
				l++;
			}
		}
		cup += (l/2+1);
		if(n-cup<=0) {
			System.out.println(n);
		}else {
			System.out.println(cup);
		}
		
	}
}