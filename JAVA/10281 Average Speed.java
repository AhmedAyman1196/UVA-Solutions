import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(System.out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
		double speed = 0 ; // km/h
		double time = 0 ;  // sec
		double distance = 0  ; // km
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine()) ;
			if(st.countTokens()==1){// query
				String s = st.nextToken() ;
				String a[] =  s.split(":") ;
				double curr = 0 ;
				curr += Double.parseDouble(a[0])*60*60 ;
				curr += Double.parseDouble(a[1])*60 ;
				curr += Double.parseDouble(a[2]) ;
				distance+= speed * ((curr - time)/3600) ;
//				System.out.println(distance+" "+curr+" "+time +" "+speed);
				time = curr ;
				pw.print(s+" ");
				pw.printf("%.2f km\n" ,distance);
			}else{ // new speed
				String s = st.nextToken() ;
				String a[] =  s.split(":") ;
				double curr = 0 ;
				curr += Double.parseDouble(a[0])*60*60 ;
				curr += Double.parseDouble(a[1])*60 ;
				curr += Double.parseDouble(a[2]) ;
				distance+= speed * ((curr - time)/3600) ;
				speed = Integer.parseInt(st.nextToken()) ;
				time = curr ;
			}
			if(!br.ready())break ;
		}
		pw.flush();
	}

}

