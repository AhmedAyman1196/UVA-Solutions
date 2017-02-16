import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/*07:05:45PM

String x =sc.next();
char inp [] = x.toCharArray();
	SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
	SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
	Date date = parseFormat.parse(x.substring(0, 5)+" "+x.substring(8, 10));
	System.out.println(displayFormat.format(date)+":"+x.substring(6, 8));
 */

public class Main
{
	static int weight[] ;
	static int maxload[];
	static int memo[][] ;
	static int n ;
	public static int dp(int index , int maxweight){
		if(memo[index][maxweight]!=-1)return memo[index][maxweight] ;
		if(index==n||maxweight<0)return  0 ;
		if(maxweight<weight[index]){return memo[index][maxweight] = dp(index+1,maxweight);} 
		int x = 1+ dp(index+1,Math.min(maxweight-weight[index], maxload[index]));
		int y = dp(index+1,maxweight);
		return memo[index][maxweight] = Math.max(x, y);
	}
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new  Scanner(System.in);
		n  =sc.nextInt() ;
		while(n!=0){
			weight = new int[1005];
			maxload = new int[1005];
			memo =new int[1005][6005] ;
			for(int i = 0 ;i<1005 ;i++)Arrays.fill(memo[i], -1);
			for(int i = 0 ;i<n ;i++){
				weight[i]=sc.nextInt() ;
				maxload[i]=sc.nextInt() ;
			}
			System.out.println(dp(0,6002));
			n = sc.nextInt() ;
		}
	}
}


class Pair implements Comparable<Pair>
{
	public int  x  ,y;
	Pair(int a , int b )
	{
		x=a;y=b;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return x==((Pair)(obj)).x && y==((Pair)obj).y;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 6*x +8*y;
	}
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return x*o.y - y*o.x;
	}
	
	
}




class Scanner
{
	StringTokenizer st;
	BufferedReader br;

	public Scanner(InputStream s)
	{
		br = new BufferedReader(new InputStreamReader(s));
	}

	public String next() throws IOException
	{
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine());
		return st.nextToken();
	}

	public int nextInt() throws IOException
	{
		return Integer.parseInt(next());
	}

	public long nextLong() throws IOException
	{
		return Long.parseLong(next());
	}

	public String nextLine() throws IOException
	{
		return br.readLine();
	}

	public double nextDouble() throws IOException
	{
		String x = next();
		StringBuilder sb = new StringBuilder("0");
		double res = 0, f = 1;
		boolean dec = false, neg = false;
		int start = 0;
		if (x.charAt(0) == '-') {
			neg = true;
			start++;
		}
		for (int i = start; i < x.length(); i++)
			if (x.charAt(i) == '.') {
				res = Long.parseLong(sb.toString());
				sb = new StringBuilder("0");
				dec = true;
			} else {
				sb.append(x.charAt(i));
				if (dec)
					f *= 10;
			}
		res += Long.parseLong(sb.toString()) / f;
		return res * (neg ? -1 : 1);
	}

	public boolean ready() throws IOException
	{
		return br.ready();
	}

}
