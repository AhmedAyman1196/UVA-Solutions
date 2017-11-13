// package UVA;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static PrintWriter out = new PrintWriter(System.out);
    static MyScanner in = new MyScanner(System.in);

    static char a[][], s[];

    static int dx[] = {0, 0, 1, -1, 1, 1, -1, -1};
    static int dy[] = {1, -1, 0, 0, 1, -1, 1, -1};
    static boolean visited[][];

    static boolean solve(int i, int j, int idx) {
        if (a[i][j] != s[idx])
            return false;
        if (idx == s.length - 1)
            return true;
        boolean res = false;
        for (int x = 0; x < 8 && !res; x++) {
            int tox = i + dx[x], toy = j + dy[x];
            if (!(tox < 0 || tox > 3 || toy < 0 || toy > 3) && !visited[tox][toy]) {
                visited[tox][toy] = true;
                res |= solve(tox, toy, idx + 1);
                visited[tox][toy] = false;
            }
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        int score[] = {0, 0, 0, 1, 1, 2, 3, 5};
        for (int tc = 1; tc <= t; tc++) {
            a = new char[4][4];
            for (int i = 0; i < 4; i++)
                a[i] = in.next().toCharArray();
            int n = in.nextInt(), ans = 0;
            while (n-- > 0) {
                s = in.next().toCharArray();
                boolean found = false;
                for (int i = 0; i < 4 && !found; i++)
                    for (int j = 0; j < 4 && !found; j++) {
                        visited = new boolean[4][4];
                        visited[i][j] = true;
                        if (solve(i, j, 0)) {
                            found = true;
                            break;
                        }
                    }

                if (found) {
                    if (s.length >= 8)
                        ans += 11;
                    else
                        ans += score[s.length];
                }

            }
            out.printf("Score for Boggle game #%d: %d\n", tc, ans);

        }
        out.flush();
    }

    static class MyScanner {
        StringTokenizer st;
        BufferedReader br;

        public MyScanner(InputStream s) {
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
            return br.ready();
        }
    }
}

