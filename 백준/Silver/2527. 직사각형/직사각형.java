import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=0; t<4; t++) {
			int[] qr1 = new int [4]; //첫번째 사각형 정보 저장할 배열
			int[] qr2 = new int [4]; //두번째 사각형 정보 저장할 배열
			//첫번째 사각형 위치 정보 입력
			for(int i=0; i<4; i++) {
				qr1[i] = sc.nextInt();
			}
			//두번째 사각형 위치정보 입력
			for(int i=0; i<4; i++) {
				qr2[i] = sc.nextInt();
			}
			if(qr1[2]<qr2[0] || qr1[0]>qr2[2] || qr1[3]<qr2[1] || qr1[1]>qr2[3]) {
				System.out.println("d");
			}else if((qr1[0]==qr2[2]&&qr1[1]==qr2[3])
					||(qr1[1]==qr2[3]&&qr1[2]==qr2[0])
					||(qr1[2]==qr2[0]&&qr1[3]==qr2[1])
					||(qr1[0]==qr2[2]&&qr1[3]==qr2[1])) {
				System.out.println("c");
			}else if((qr1[1]==qr2[3]&&(qr1[0]<qr2[2]||qr1[2]>qr2[0]))
					||(qr1[2]==qr2[0]&&(qr2[1]<qr1[3]||qr1[1]<qr2[3]))
					||(qr1[3]==qr2[1]&&(qr1[0]<qr2[2]||qr1[2]>qr2[0]))
					||(qr1[0]==qr2[2]&&(qr1[1]<qr2[3]||qr1[3]<qr2[1]))) {
				System.out.println("b");
			}
			else {
				System.out.println("a");
			}
			
			
		}
	}
}