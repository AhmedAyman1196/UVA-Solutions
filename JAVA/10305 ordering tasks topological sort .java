import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	public static ArrayList<Integer> ts ; 
	public static int VISITED = 1 ;
	public static int UNVISITED = 0 ; 
	public static ArrayList<Integer>[] AdjList ; 
	public static int[] dfs_num ;
	
	public static void dfs2(int u){
		dfs_num[u] = VISITED ;
		for(int i = 0  ;i<AdjList[u].size();i++){
			int  v  = AdjList[u].get(i) ; 
			if(dfs_num[v]==UNVISITED)dfs2(v);
		}
		ts.add(u) ;
	}
	
	public static void main(String[] args) throws IOException {
		
			Scanner sc = new Scanner(System.in);
			while(true){
				int n = sc.nextInt() ; 
				int m = sc.nextInt() ;
				if(m==0 && n==0)break;
				AdjList = new ArrayList[n];
				dfs_num = new int[n] ;
				ts = new ArrayList<Integer>() ;
				for(int i  = 0 ; i<AdjList.length ; i ++)
				AdjList[i] = new ArrayList<Integer>();
				
				while(m-->0){
					int i = sc.nextInt()-1 ; 
					int j =  sc.nextInt()-1 ; 
					AdjList[i].add(j) ;
				}
				for(int i = 0 ; i<n ; i++){
					if(dfs_num[i]==UNVISITED)dfs2(i);
				}
				for(int i =ts.size()-1 ; i>=0; i--)
				System.out.print(ts.get(i)+1+" ");
			System.out.println(); 
			}
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

	 class Scanner 
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
