import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = 1 ;
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); //streets
			int b = Integer.parseInt(st.nextToken()) ; // allocated integers
			if(a==0&&b==0)break ;
			int ans = -1 ;
			for(int i = 1 ; i <= 27  ; i ++){
				if(b*i>=a){
					ans = i ;
					break ;
				}
			}
			pw.printf("Case %d: ", t++);
			pw.println(ans==-1? "impossible" : ans-1);
		}
		pw.flush();
	}

}

