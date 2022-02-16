#include <cstdio>

using namespace std;
const int M=1<<4, S=1<<3;

int seg[M];
int lazy[M];

void propa(int s, int e, int n){
	if(lazy[n]==0)return;
	if(n<S){
		lazy[n*2]^=1;
		lazy[n*2+1]^=1;
		
		seg[n]=(e-s+1)-seg[n];
	}
	else{
		seg[n]^=1;
	}
	lazy[n]=0;
}

void update(int s, int e, int n, int ss, int ee){
	propa(ss,ee,n);
	if(e<ss||ee<s)return;
	if(s<=ss&&ee<=e){
		lazy[n]^=1;
		propa(ss,ee,n);
		return;
	}
	int mid = (ss+ee)/2;
	update(s,e,n*2,ss,mid);
	update(s,e,n*2+1,mid+1,ee);
	seg[n]=seg[n*2]+seg[n*2+1];
}

int sum(int s, int e, int n, int ss, int ee){
	propa(ss,ee,n);
	if(e<ss||ee<s)return 0;
	if(s<=ss&&ee<=e) return seg[n];
	int mid=(ss+ee)/2;

	return sum(s,e,n*2,ss,mid)+sum(s,e,n*2+1,mid+1,ee);
}

int main(void){
	int N,M; scanf("%d %d ",&N,&M);
	for(int i=0; i<M; i++){
		int n, s, e; scanf("%d %d %d ",&n,&s,&e);
		if(n==0){
			update(s-1,e-1,1,0,S-1);
		}
		else{
			printf("%d\n",sum(s-1,e-1,1,0,S-1));
		}
	}
}
