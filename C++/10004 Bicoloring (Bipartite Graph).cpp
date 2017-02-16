    #include <cstdlib>
    #include <iostream>
    #include <map>
    #include <stdio.h>
    #include <vector>
    #include<bits/stdc++.h>
    #include <ctype.h>
    #include <list>
    #include <stack>
    #include <queue>
    #include <string.h>
    #include <iomanip>
    #include <string>
    #include <algorithm>
    #include <cmath>
    #define _CRT_SECURE_NO_DEPRECATE
    #define INF 1000000000
    #define Set(a, s) memset(a, s, sizeof (a))
    #define forpos(i,j,k) for (int i=0 ; i<j ; i+=k)
    #define forneg(i,j,k) for (int i=j ;i>=0 ;i-=k)
    #define PI 3.14159265358979323846
    #define pf printf
    #define SSTR( x ) dynamic_cast< std::ostringstream & >( \
           ( std::ostringstream() << std::dec << x ) ).str()
    #include<queue>
    #define UNVISITED 0
    #define VISITED  1


    using namespace std;

    typedef long long ll;
    typedef std::pair<int,int> ii;
    typedef std::pair<std::string,int> si;
    typedef vector<int> vi;
    typedef vector<ii> vii;
    typedef std::pair<int , ii> iii ;
    class CompareDist
    {
    public:
        bool operator()(ii x,ii y) {
          if(x.first==y.first)
          return x.second<y.second;
          return x.first>y.first ;
      }
    };

    bool compare(ii x,ii y) {
          if(x.first==y.first)
          return x.second<y.second;
          return x.first>y.first ;
      }

/* Min Priority Queue : priority_queue<int, std::vector<int>, std::greater<int> > my_min_heap;*/

/*Set implementation :

        set<int> myset;
        set<int>::iterator it;
                it = myset.find(a[i]);
                if(myset.end()==it){myset.insert(a[i]);

*/
    int main(){
       ios_base::sync_with_stdio(false);
        while(true){
            int n ;  cin>>n ;
            vector<vector<int> > adjList ;
            if(n==0)break ;
            // initializing the List
            forpos(i , n ,1 ){
                vector<int> x ;
                adjList.push_back(x);
              }
           int edges ; cin>>edges ;
           while(edges--){
            int i ;cin>>i ;
            int j ; cin>>j ;
            adjList[i].push_back(j) ;
            adjList[j].push_back(i) ;
           }
           // List filled from input
           // bipartite code :
           queue<int> q ; q.push(0);
           vi color(n,INF);color[0]=0;
           bool isBipartite = true ;
           while(!q.empty()&isBipartite){
            int u  = q.front() ; q.pop() ;
            for(int j = 0 ; j<(int)adjList[u].size() ; j++){
                int v = adjList[u][j];
                if(color[v]==INF){
                    color[v] = 1 - color[u] ;
                    q.push(v) ;
                   } else if(color[v]==color[u]){
                       isBipartite = false ;
                       break ; }
                    }
                 }
            if(isBipartite)cout<<"BICOLORABLE."<<endl ;
            else cout<<"NOT BICOLORABLE."<<endl ;

            adjList.clear() ;
           }
        }



