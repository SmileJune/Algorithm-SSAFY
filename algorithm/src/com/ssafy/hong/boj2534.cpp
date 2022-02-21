#include <cstdio>
#include <vector>
#include <queue>

using namespace std;
typedef long long ll;
typedef pair<int,int> p;
const int MAX=300001, MOD=1000000007;

int ind[MAX], outd[MAX], m[MAX], M[MAX];
int N, K, P;
vector<int> adj[MAX], badj[MAX];
ll POW[MAX];
void setValue(vector<int>* v,int* degree, int* arr, int init, int d){
	priority_queue<int,vector<int>, greater<int>> q;
	int val = init;
	for(int i=0; i<K; i++)if(degree[i]==0)q.push(i);
	while(!q.empty()){
		int curr = q.top();
		q.pop();
		val+=d;
		arr[curr]=val;
		
		for(auto next : v[curr]){
			degree[next]--;
			if(degree[next]==0){
				q.push(next);
			}
		}
	}
}
int main(void){
	scanf("%d %d %d ",&N,&K,&P);
	for(int i=0; i<P; i++){
		int s, e; scanf("%d %d ",&s,&e);
		adj[s].push_back(e);
		ind[e]++;
		badj[e].push_back(s);
		outd[s]++;
	}
	POW[0]=1;
	for(int i=1; i<K; i++){
		POW[i]=POW[i-1]*N;
		POW[i]%=MOD;
	}
	setValue(badj,outd,M,N-K-1,+1);
	setValue(adj,ind,m,K,-1);
	for(int i=0; i<K; i++)M[i]-=m[i];
	ll ans = 0;
	for(int i=0; i<K; i++){
		ans+=(POW[i]*M[i])%MOD;
		ans%=MOD;
	}
	printf("%lld",ans);
}

