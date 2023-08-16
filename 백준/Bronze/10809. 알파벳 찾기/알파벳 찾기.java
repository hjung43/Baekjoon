import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next(); //문자열 입력받기
		int [] alphabet = new int[26]; //알파벳 위치 저장할 문자열
		Arrays.fill(alphabet,-1); //알파벳 문자열 모든 인덱스 -1로 초기화
								  //(arr.fill(arr,초기화값) = 모든 인덱스의 값을 초기화값으로 바꿈)
		//알파벳 위치 alphabet배열에 저장하기
		for(int i=0; i<str.length(); i++) {
			if(alphabet[str.charAt(i)-97]==-1) //같은 문자일때는 처음 위치를 저장하기 위해 -1일때만 위치 수정
				alphabet[str.charAt(i)-97] = i; //str에서 한글자씩 문자로 나눠 a의 아스키코드값(97) 빼기
		}
		//결과 출력
		for(int i=0; i<26; i++) 
			System.out.print(alphabet[i]+" ");
	}

}