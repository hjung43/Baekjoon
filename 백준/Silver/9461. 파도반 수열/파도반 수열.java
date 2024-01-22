import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long[] pArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pArr = new long[101]; //파도반 수열 담을 배열
		int T = Integer.parseInt(br.readLine()); //테스트케이스 수
		
		//파도반 수열 시작
		pArr[1]=1;
		pArr[2]=1;
		pArr[3]=1;
		
		//테스트케이스 만큼 반복
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			//pArr[n]찾아서 출력
			System.out.println(padovan(n));
		}
		
	}
	//pArr[n]찾는 메소드
	static long padovan( int n ) {
		//n이 (이미주어진)3보다 크고 값이 없을때
		if(n>3 && pArr[n]==0) {
			pArr[n] = padovan(n-2) + padovan(n-3);
		}
		
		return pArr[n];
	}
}