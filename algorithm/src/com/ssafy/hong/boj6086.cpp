#include <cstdio>
#include <queue>
#include <vector>

using namespace std;

const int MAX=62, INF=1<<30;

int f[MAX][MAX], c[MAX][MAX];

int main(void){
	int N; scanf("%d ",&N);
	for(int i=0; i<N; i++){
		char s,e; int cc; scanf("%c %c %d ",&s,&e,&cc);
		s-='A'; e-='A';
		c[s][e]+=cc;
		c[e][s]+=cc;
	}
	int flow=0;
	while(true){
		vector<int> parent(MAX,-1);
		parent[0]=0;
		queue<int> q;
		q.push(0);

		while(!q.empty() &&parent['Z'-'A']==-1){
			int curr = q.front();
			q.pop();

			for(int i=0; i<MAX; i++){
				if(c[curr][i] - f[curr][i]>0 && parent[i]==-1){
					parent[i]=curr;
					q.push(i);
				}
			}
		}
		
		if(parent['Z'-'A']==-1)break;
		int amount = INF;
		for(int n = 'Z'-'A'; n!=0; n=parent[n]){
			amount = min(amount, c[parent[n]][n]-f[parent[n]][n]);
		}
		for(int n = 'Z'-'A'; n!=0; n=parent[n]){
			f[parent[n]][n]+=amount;
			f[n][parent[n]]-=amount;
		}
		flow+=amount;
	}
	printf("%d",flow);
}
