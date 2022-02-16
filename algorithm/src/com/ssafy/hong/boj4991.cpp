#include <cstdio>
#include <vector>
#include <queue>
#define RAN (ty<0 || tx<0|| ty>=N|| tx>=M)
using namespace std;
typedef pair<pair<int,int>,pair<int,int>> p;
const int INF=1<<30;
int dp[21][21][1<<10];
bool visit[21][21][1<<10];
int dy[4]={1,-1,0,0}, dx[4]={0,0,1,-1};
char map[22][22];

int main(void){
	while(true){
		int N, M; scanf("%d %d ",&M,&N);

		if(N==0 && M==0)break;
		
		int n = '0';
		int sy,sx;
		for(int i=0; i<N; i++){
			scanf("%s ",map[i]);
			for(int j=0; j<M; j++){
				if(map[i][j]=='*')map[i][j]=n++;
				if(map[i][j]=='o'){
					sy=i, sx=j;
					map[i][j]='.';
				}
			}
		}
		int limit = (1<<(n-'0'))-1;
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				for(int k=0; k<=limit; k++){
					dp[i][j][k]=INF;
					visit[i][j][k]=0;
				}
			}
		}
		priority_queue<p,vector<p>, greater<p>> pq;
		pq.push({{0,sy},{sx,0}});
		dp[sy][sx][0]=0;
		
		while(!pq.empty()){
			int cy,cx,cs;
			do{
				cy = pq.top().first.second;
				cx = pq.top().second.first;
				cs = pq.top().second.second;
				pq.pop();
			}while(!pq.empty() && visit[cy][cx][cs]);
			if(visit[cy][cx][cs])break;
			visit[cy][cx][cs]=true;


			 for(int i=0; i<4; i++){
				int ty=cy+dy[i];
				int tx=cx+dx[i];
				if(RAN||map[ty][tx]=='x')continue;
				if(map[ty][tx]=='.'){
					if(dp[ty][tx][cs] > dp[cy][cx][cs]+1){
						dp[ty][tx][cs]=dp[cy][cx][cs]+1;
						pq.push({{dp[ty][tx][cs],ty},{tx,cs}});
					}
				}else{
					int ts = cs|(1<<(map[ty][tx]-'0'));
					if(dp[ty][tx][ts]>dp[cy][cx][cs]+1){
						dp[ty][tx][ts]=dp[cy][cx][cs]+1;
						pq.push({{dp[ty][tx][ts],ty},{tx,ts}});
					}	
				}
			}
		}
		
		int ans = INF;
		for(int i=0; i<N; i++)for(int j=0; j<M; j++)ans=min(ans,dp[i][j][limit]);
		printf("%d\n",ans==INF?-1:ans);
	}
	return 0;
}
