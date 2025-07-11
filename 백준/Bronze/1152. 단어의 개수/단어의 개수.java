import java.io.*;
import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = (br.readLine()).trim();
        String[] words = (str).split(" ");
        if(str.isEmpty()){
            System.out.println("0");
        }else{
            System.out.println(words.length);
        }

    }
}