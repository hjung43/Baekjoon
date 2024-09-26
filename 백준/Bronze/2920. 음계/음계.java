import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ascend = 1; //음이 c부터 하나씩 올라가는 변수
        int descend = 8; //음이 C부터 하나씩 내려오는 변수

        for(int i=0; i<8; i++){
            int pitch = Integer.parseInt(st.nextToken()); //현재 음 저장
            if(pitch==ascend){ 
                ascend++;
            }
            if (pitch==descend) {
                descend--;
            }
        }

        if(ascend==9){
            System.out.println("ascending");
        }else if(descend==0){
            System.out.println("descending");
        }else{
            System.out.println("mixed ");
        }


    }
}