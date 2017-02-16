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
        int worldX , worldY ;
        cin>>worldX>>worldY ;
        int xpos , ypos , lastX ,lastY ;
        char direction  ,  lastdirection;
        int safe[worldX+1][worldY+1] ;
            forpos(i,worldX+1,1)
            forpos(j,worldY+1,1)safe[i][j]=0 ;
        while(cin>>xpos){
            cin>>ypos ;
            cin>>direction ;
            char command ;
            bool lost=false ;
            string s ; cin>>s ;

            for(int i  = 0 ; i<s.length();i++){
                command = s[i] ;
                lastX = xpos;  lastY = ypos; lastdirection = direction ;
                if(command=='F'){
                    if(direction=='N')ypos++;
                    if(direction=='S')ypos--;
                    if(direction=='E')xpos++;
                    if(direction=='W')xpos--;
                }
                else if(command=='R'){

                    if(direction=='N')direction='E' ;
                    else if(direction=='S')direction='W' ;
                    else if(direction=='E')direction='S' ;
                    else if(direction=='W')direction='N' ;
                }
                else if(command=='L'){
                    if(direction=='N')direction='W' ;
                    else if(direction=='S')direction='E' ;
                    else if(direction=='E')direction='N' ;
                    else if(direction=='W')direction='S' ;
                }
                if((xpos<0||ypos<0||xpos>worldX||ypos>worldY)&&safe[xpos][ypos]){
                    xpos = lastX ;
                    ypos = lastY ;

                }
                else if((xpos<0||ypos<0||xpos>worldX||ypos>worldY)&&!safe[xpos][ypos]){
                    safe[xpos][ypos] = 1 ;
                    lost = true ;
                    xpos = lastX ;
                    ypos = lastY ;
                    direction = lastdirection ;
                    break ;
                }

            }
            if(lost)cout<<xpos<<" "<<ypos<<" "<<direction<<" "<<"LOST"<<endl ;
            else cout<<xpos<<" "<<ypos<<" "<<direction<<endl ;
        }
    return 0;
    }
