import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main { 
	public static BigInteger[][] memo ; 
	public static BigInteger result ;
	public static BigInteger  trib(int n, int back )
	{
		if(n<=1)return BigInteger.ONE;
		if(!(memo[n][back]==null))return memo[n][back] ; 
		BigInteger z =new BigInteger("0") ;
		for(int i=1;i<=back;i++){
			z=z.add(trib(n-i ,back)) ; 
		}
		memo[n][back] = z.add(BigInteger.ONE) ;
	return memo[n][back]; 
	}
	

	
	public static void main(String[] args) throws IOException {
		
			Scanner sc = new Scanner(System.in);
			int counter = 1 ;
			memo =  new BigInteger[61][61] ;
			while(true){
				int n = sc.nextInt() ; 
				if(n>60)break ; 
				int back = sc.nextInt() ; 
				System.out.printf("Case %d: %s\n",counter++,trib(n,back).toString());
			
	}
			
			
	}		
		class Pair 
	{
		char  x ; int y ;
		Pair(char a , int b)
		{
			x=a;y=b;
		}
		
	}

	 static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}
		
		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}
		
		public double nextDouble() throws IOException
		{
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			double res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if(x.charAt(0) == '-')
			{
				neg = true;
				start++;
			}
			for(int i = start; i < x.length(); i++)
				if(x.charAt(i) == '.')
				{
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				}
				else
				{
					sb.append(x.charAt(i));
					if(dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg?-1:1);
		}
		
		public boolean ready() throws IOException {return br.ready();}
	}
}
	 /*public static boolean distinct(int x ){
		String str = ""+x ; 
		if (str.length() > 10) { 
	        return false;
	    }
	    int checker = 0;
	    for (int i = 0; i < str.length(); i++) {
	        int val = str.charAt(i) - '0';
	        if ((checker & (1 << val)) > 0) return false;
	        checker |= (1 << val);
	    }
	    return true;
	}
	*/
