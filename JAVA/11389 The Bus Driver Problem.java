import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ProblemA {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// n morning and n afternoon routes  = n bus drivers
		// if time exceed d he is paid r per hour
		Integer n  , r , d , morn[] , after[] , ans   ;
		while(true){
			n  = sc.nextInt() ; 
			d = sc.nextInt() ;
			r=  sc.nextInt()  ;
			if(r==0&&d==0&&n==0)break ;
			morn = new Integer[n] ;
			after = new Integer[n] ;
			for(int i = 0 ; i < n  ; i++)
				morn[i] = sc.nextInt() ;
			for(int i = 0 ; i < n ; i ++)
				after[i] = sc.nextInt() ;
			Arrays.sort(morn);
			Arrays.sort(after);
			ans = 0;
			for(int i = 0 , j = n-1 ;  i < n ; i ++ , j--){
					int x = morn[i]+after[j] ;
					ans+= r * Math.max(0, x-d) ;
				}
			System.out.println(ans);
		}
	}
}
