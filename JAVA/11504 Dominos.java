import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
    static ArrayList<Integer> out[], in[];
    static int counter, SCC, dfs_num[], dfs_low[], n, m;
    static Stack<Integer> stack;
    static boolean visited[];
    static int SCC_NUM [];
    static boolean isRoot [];
    static void solve() {
        for (int i = 0; i < n; i++)
            if (dfs_num[i] == 0)
                tarjanSCC(i);
    }
 
    static int res () {
        Arrays.fill(isRoot, true);
        for (int i = 0; i < n; i++)
            for (int j = 0; j < out[i].size(); j++)
                if (SCC_NUM[i] != SCC_NUM[out[i].get(j)])
                    isRoot[SCC_NUM[out[i].get(j)]] = false;
        int ret = 0;
        for (int i = 0; i < SCC; i++)
            ret += (isRoot[i] ? 1 : 0);
        return ret;
    }
    static void tarjanSCC(int u) {
        dfs_num[u] = dfs_low[u] = ++counter;
        stack.push(u);
        visited[u] = true;
        for(int i = 0, size = out[u].size(); i < size; i++) {
            int v = out[u].get(i);
            if (dfs_num[v] == 0)
                tarjanSCC(v);
            if (visited[v])
                dfs_low[u] = Math.min(dfs_low[u], dfs_low[v]);
        }
        if (dfs_num[u] == dfs_low[u]) {
            // SCC found
            while (true) {
                int v = stack.pop();
                SCC_NUM[v] = SCC;
                visited[v] = false;
                if (v == u)
                    break;
            }
            SCC++;
        }
    }
 
	public static void main(String[] args) throws IOException {
        int tc = sc.nextInt() , t = 1;
        while (tc-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            out = new ArrayList[n];
            in = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                out[i] = new ArrayList<>();
                in[i] = new ArrayList<>();
            }
            // input
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt() - 1, y = sc.nextInt() - 1; // if(x falls):
                // y falls
                out[x].add(y);
                in[y].add(x);
            }
            // initialize
            visited = new boolean[n];
            dfs_num = new int[n];
            dfs_low = new int[n];
            counter = SCC = 0;
            stack = new Stack<>();
            SCC_NUM = new int[n];
            solve();
            isRoot = new boolean[SCC];
            pw.println(res());
        }
 
        pw.flush();
        pw.close();
    }
 
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;
 
        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }
 
        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
 
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
 
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
 
        public String nextLine() throws IOException {
            return br.readLine();
        }
 
        public double nextDouble() throws IOException {
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
 
        public boolean ready() throws IOException {
            return br.ready() || st.hasMoreTokens();
        }
 
    }
}
