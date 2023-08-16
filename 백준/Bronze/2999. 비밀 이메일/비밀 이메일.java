import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); //비밀 메시지 임력
        int n = str.length(); //메시지 글자 수 N
        int r = 1; //R<=C이고, R*C=N인 수 중 가장 큰 R을 찾기위한 변수
        int c = n/r; //r과 곱했을때 n이 되어야 하는 값을 찾기위한 변수
        int R = 0; ////R<=C이고, R*C=N인 수 중 가장 큰 R을 저장할 변수
        //r을 1씩 늘려가면서 조건에 만족하는 가장 큰 R을 찾는 while문
        while(r<=c) {
            if(r*c == n && r>R) { //r과c의 곱이 n이고 r이 현재 최대값 보다 크다면
                R=r; //최대값 r로 바꾸기
            }
            r++; //r을 1씩 늘려가며 r최댓값 찾기
            c = n/r; //반복할때 마다 n/r로 초기화
        }
        int C = n/R; //조건에 맞는 R에 부합하는 최종C
        
        char[][] mail = new char[R][C]; //비밀 메시지 문자로 나눠 담을 배열
        
        //배열에 문자 열 우선순회로 넣기
        for(int i=0; i<C; i++) {
        	String s = str.substring(i*R, i*R+R); //.substring으로 문자열 열 크기에 맞춰 자르기
        										  //.substring(시작인덱스, 끝인덱스) -> 시작인덱스 부터 끝인덱스 -1까지 문자열 자르기
        	for(int j=0; j<R; j++) {
        		mail[j][i]  = s.charAt(j); //자른 문자열 문자로 쪼개서 배열에 순서대로 넣기
        	}
        }
        //배열 행 우선순회로 출력하기
        for(int i=0; i<R; i++) {
        	for(int j=0; j<C; j++) {
        		System.out.print(mail[i][j]);
        	}
        }
    }
}