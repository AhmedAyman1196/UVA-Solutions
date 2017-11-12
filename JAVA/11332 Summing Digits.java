import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ProblemA {
	static Scanner sc = new Scanner(System.in);
// 11332 - Summing DigitsS
	public static void main(String[] args) throws IOException {
			int n =sc.nextInt()  ;
			while(n!=0){
				String sum=""+n;
				while(sum.length()>1){
					int x = 0 ;
					for(int i = 0 ; i < sum.length() ; i ++)
						x+=(sum.charAt(i)-'0') ;
					sum = ""+x ;
				}
				
				System.out.println(sum);
				n =sc.nextInt() ;
			}
	}
}
