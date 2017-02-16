import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static PrintWriter pw = new PrintWriter(System.out);

	public static void main(String[] args) throws Exception {
		int n = sc.nextInt(), m = sc.nextInt();
		while (true) {
			if (n == 0 && m == 0)
				break;
			UnionFind uf = new UnionFind(n) ;
			for(int i = 0 ; i< m ; i ++){
				int k = sc.nextInt()-1 , first = sc.nextInt() ;
				while(k-->0)
					uf.unionSet(sc.nextInt(), first);
			}
			pw.println(uf.sizeOfSet(0));
			n = sc.nextInt();
			m = sc.nextInt();
		}
		pw.flush();pw.close();
	}

	static class UnionFind { 
		
		private Vector<Integer> p, rank, setSize;
		private int numSets;

		public UnionFind(int N) {
			p = new Vector<Integer>(N);
			rank = new Vector<Integer>(N);
			setSize = new Vector<Integer>(N);
			numSets = N;
			for (int i = 0; i < N; i++) {
				p.add(i);
				rank.add(0);
				setSize.add(1);
			}
		}

		public int findSet(int i) {
			if (p.get(i) == i)
				return i;
			else {
				int ret = findSet(p.get(i));
				p.set(i, ret);
				return ret;
			}
		}

		public Boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) {
			if (!isSameSet(i, j)) {
				numSets--;
				int x = findSet(i), y = findSet(j);
				
				if (rank.get(x) > rank.get(y)) {
					p.set(y, x);
					setSize.set(x, setSize.get(x) + setSize.get(y));
				} else {
					p.set(x, y);
					setSize.set(y, setSize.get(y) + setSize.get(x));
					if (rank.get(x) == rank.get(y))
						rank.set(y, rank.get(y) + 1);
				}
			}
		}
		public int numDisjointSets() {
			return numSets;
		}
		public int sizeOfSet(int i) {
			return setSize.get(findSet(i));
		}
	}

}
